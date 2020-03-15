package com.ruoyi.project.performance.service.impl;

import java.util.List;

import com.ruoyi.project.performance.domain.PerforResult;
import com.ruoyi.project.performance.mapper.PerforResultMapper;
import com.ruoyi.project.performance.service.IPerforResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PerforResultServiceImpl implements IPerforResultService {
  @Autowired
  PerforResultMapper resultMapper;

  @Override
  public List<PerforResult> selectResultList(PerforResult result) {
    return resultMapper.selectResultList(result);
  }
}
