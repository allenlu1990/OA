package com.ruoyi.project.performance.controller;

import java.util.List;

import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.project.performance.domain.PerforResult;
import com.ruoyi.project.performance.service.IPerforResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/performance/result")
public class PerforResultController extends BaseController {

  @Autowired
  IPerforResultService resultService;
  /**
   * 获取绩效申请列表
   */
  @PreAuthorize("@ss.hasPermi('performance:result:list')")
  @GetMapping("/list")
  public TableDataInfo list(PerforResult result) {
    startPage();
    List<PerforResult> list = resultService.selectResultList(result);
    return getDataTable(list);
  }
}
