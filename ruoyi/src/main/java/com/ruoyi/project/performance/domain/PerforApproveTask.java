package com.ruoyi.project.performance.domain;

/**
 * 绩效审批对象 performance_approve_task
 *
 * @author ruoyi
 * @date 2020-03-15
 */
public class PerforApproveTask extends PerforApplication {
  private static final long serialVersionUID = 1L;

  /**
   * 任务ID
   */
  private Long id;
  /**
   * 审批人ID
   */
  private Long approverId;
  /**
   * 评审结果
   */
  private String result;

  public static long getSerialVersionUID() {
    return serialVersionUID;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getApproverId() {
    return approverId;
  }

  public void setApproverId(Long approverId) {
    this.approverId = approverId;
  }

  public String getResult() {
    return result;
  }

  public void setResult(String result) {
    this.result = result;
  }

  @Override
  public String toString() {
    return "PerforApproveTask{" +
        "id=" + id +
        ", approverId=" + approverId +
        ", result='" + result + '\'' +
        '}';
  }
}
