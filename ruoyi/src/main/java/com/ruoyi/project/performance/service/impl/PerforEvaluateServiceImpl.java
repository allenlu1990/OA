package com.ruoyi.project.performance.service.impl;

import java.util.List;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.project.performance.domain.OwnersInfo;
import com.ruoyi.project.performance.domain.PerforApproveTask;
import com.ruoyi.project.performance.mapper.PerforEvaluateMapper;
import com.ruoyi.project.performance.service.IPerforEvaluateService;
import com.ruoyi.project.system.domain.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 绩效审批Service业务层处理
 *
 * @author ruoyi
 * @date 2020-03-15
 */
@Service
public class PerforEvaluateServiceImpl implements IPerforEvaluateService {
  @Autowired
  private PerforEvaluateMapper performanceApproveTaskMapper;

  /**
   * 查询绩效审批
   *
   * @param id 绩效审批ID
   * @return 绩效审批
   */
  @Override
  public PerforApproveTask selectPerforApproveTaskById(Long id) {
    return performanceApproveTaskMapper.selectPerforApproveTaskById(id);
  }

  /**
   * 查询绩效审批列表
   *
   * @param performanceApproveTask 绩效审批
   * @return 绩效审批
   */
  @Override
  public List<PerforApproveTask> selectPerforApproveTaskList(PerforApproveTask performanceApproveTask) {
    return performanceApproveTaskMapper.selectPerforApproveTaskList(performanceApproveTask);
  }

  /**
   * 新增绩效审批
   *
   * @param performanceApproveTask 绩效审批
   * @return 结果
   */
  @Override
  public int insertPerforApproveTask(PerforApproveTask performanceApproveTask) {
    return performanceApproveTaskMapper.insertPerforApproveTask(performanceApproveTask);
  }

  /**
   * 修改绩效审批
   *
   * @param performanceApproveTask 绩效审批
   * @return 结果
   */
  @Override
  public int updatePerforApproveTask(PerforApproveTask performanceApproveTask) {
    return performanceApproveTaskMapper.updatePerforApproveTask(performanceApproveTask);
  }

  /**
   * 删除绩效审批对象
   *
   * @param ids 需要删除的数据ID
   * @return 结果
   */
  @Override
  public int deletePerforApproveTaskByIds(String ids) {
    return performanceApproveTaskMapper.deletePerforApproveTaskByIds(Convert.toStrArray(ids));
  }

  /**
   * 删除绩效审批信息
   *
   * @param id 绩效审批ID
   * @return 结果
   */
  @Override
  public int deletePerforApproveTaskById(Long id) {
    return performanceApproveTaskMapper.deletePerforApproveTaskById(id);
  }

  @Override
  public List<OwnersInfo> getTaskOwners(PerforApproveTask approveTask) {
    return performanceApproveTaskMapper.getTaskOwners(approveTask);
  }

}
