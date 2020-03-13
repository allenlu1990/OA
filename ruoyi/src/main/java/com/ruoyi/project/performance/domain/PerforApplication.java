package com.ruoyi.project.performance.domain;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.framework.web.domain.BaseEntity;

public class PerforApplication extends BaseEntity {
  private static final long serialVersionUID = 1L;

  /** 申请ID */
  private Long applicationId;

  /** 申请标题 */
  private String applicationTitle;

  /** 被考核人 */
  private Long ownerId;

  /** 被考核人名字 */
  private String ownerName;

  /** 考核内容 */
  private String applicationContent;

  /** 考核时间段 */
  @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
  private Date applicationDate;

  /** 申请状态（0正常 1关闭） */
  private String status;

  public String getOwnerName() {
    return ownerName;
  }

  public void setOwnerName(String ownerName) {
    this.ownerName = ownerName;
  }

  public Long getApplicationId() {
    return applicationId;
  }

  public void setApplicationId(Long applicationId) {
    this.applicationId = applicationId;
  }

  public String getApplicationTitle() {
    return applicationTitle;
  }

  public void setApplicationTitle(String applicationTitle) {
    this.applicationTitle = applicationTitle;
  }

  public Long getOwnerId() {
    return ownerId;
  }

  public void setOwnerId(Long ownerId) {
    this.ownerId = ownerId;
  }

  public String getApplicationContent() {
    return applicationContent;
  }

  public void setApplicationContent(String applicationContent) {
    this.applicationContent = applicationContent;
  }

  public Date getApplicationDate() {
    return applicationDate;
  }

  public void setApplicationDate(Date applicationDate) {
    this.applicationDate = applicationDate;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }
}
