package com.ruoyi.project.performance.service.impl;

import java.util.List;

import com.ruoyi.project.performance.domain.PerforApplication;
import com.ruoyi.project.performance.mapper.PerforApplicationMapper;
import com.ruoyi.project.performance.service.IPerforApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PerforApplicationServiceImpl implements IPerforApplicationService {

  @Autowired
  PerforApplicationMapper perforApplicationMapper;

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
    return perforApplicationMapper.insertApplication(application);
  }

  @Override
  public int updateApplication(PerforApplication application) {
    return perforApplicationMapper.updateApplication(application);
  }

  @Override
  public int deleteApplicationById(Long applicationId) {
    return perforApplicationMapper.deleteApplicationById(applicationId);
  }
}
