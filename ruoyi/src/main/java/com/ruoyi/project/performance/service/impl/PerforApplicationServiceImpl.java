package com.ruoyi.project.performance.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.ruoyi.project.performance.domain.PerforApplication;
import com.ruoyi.project.performance.domain.PerforApproveTask;
import com.ruoyi.project.performance.mapper.PerforApplicationMapper;
import com.ruoyi.project.performance.mapper.PerforEvaluateMapper;
import com.ruoyi.project.performance.mapper.PerforResultMapper;
import com.ruoyi.project.performance.service.IPerforApplicationService;
import com.ruoyi.project.system.mapper.SysDictDataMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PerforApplicationServiceImpl implements IPerforApplicationService {

  @Autowired
  PerforApplicationMapper perforApplicationMapper;

  @Autowired
  SysDictDataMapper sysDictDataMapper;

  @Autowired
  PerforEvaluateMapper perforEvaluateMapper;

  @Autowired
  PerforResultMapper perforResultMapper;

  @Override
  public PerforApplication selectApplicationById(Long applicationId) {
    return perforApplicationMapper.selectApplicationById(applicationId);
  }

  @Override
  public List<PerforApplication> selectApplicationList(PerforApplication application) {
    return perforApplicationMapper.selectApplicationList(application);
  }

  @Override
  public int insertApplication(PerforApplication application) {
    perforApplicationMapper.insertApplication(application);
    if (application.getApplicationId() > 0) {
      generateEvaluateTasks(application);
      return 1;
    } else {
      return 0;
    }
  }

  @Override
  public int updateApplication(PerforApplication application) {
    return perforApplicationMapper.updateApplication(application);
  }

  @Override
  public int deleteApplicationById(Long applicationId) {
    return perforApplicationMapper.deleteApplicationById(applicationId);
  }

  private void generateEvaluateTasks(PerforApplication application) {
    Long applicationId = application.getApplicationId();
    Long ownerId = application.getOwnerId();
    //
    //    List<SysDictData> ranksList = sysDictDataMapper.selectDictDataByType("perfor_evaluate_range");
    //    HashMap<Long, Double> ranksRatioMap = new HashMap<>();
    //    ranksList.stream().collect(Collectors.toMap(SysDictData::getDictSort, SysDictData::getDictValue))
    //        .forEach((k, v) -> ranksRatioMap.put(k, Long.valueOf(v) / 100.0));

    HashMap<Integer, List<Long>> ranksIdMap = new HashMap<>();
    //TODO 后续升级改成存储过程
    //找上级
    List<Long> leaderId = perforEvaluateMapper.selectCorrelateIds(ownerId);
    if (leaderId.size() > 0) {
      ranksIdMap.put(3, leaderId);
      //找领导的下级（找平级）
      List<Long> leaderSubordinatesId = perforEvaluateMapper.selectReverseCorrelateIds(leaderId.get(0));
      //去掉自己
      leaderSubordinatesId.remove(ownerId);
      ranksIdMap.put(2, leaderSubordinatesId);
      //找上上级
      List<Long> leaderLeaderId = perforEvaluateMapper.selectCorrelateIds(leaderId.get(0));
      ranksIdMap.put(4, leaderLeaderId);
    }
    //找下级
    List<Long> subordinatesId = perforEvaluateMapper.selectReverseCorrelateIds(ownerId);
    ranksIdMap.put(1, subordinatesId);
    ArrayList<PerforApproveTask> perforApproveTasks = new ArrayList<>();
    ranksIdMap.forEach((rank, v) -> {
      if (v.size() > 0) {
        v.forEach(id ->{
          //            perforEvaluateMapper.insertPerforApproveTask(new PerforApproveTask(id,rank,applicationId))
          PerforApproveTask approveTask = new PerforApproveTask();
          approveTask.setApproverId(id);
          approveTask.setApproverRank(rank);
          approveTask.setApplicationId(applicationId);
          perforApproveTasks.add(approveTask);
        });
      }
    });
    perforEvaluateMapper.insertPerforApproveTaskBatch(perforApproveTasks);
    generateResultTasks(applicationId);
  }

  private void generateResultTasks(Long applicationId){
    perforResultMapper.insertResult(applicationId);
  }
}
