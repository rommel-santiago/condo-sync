package com.synctrack.condosync.dto;

import com.synctrack.condosync.model.WorkPermit;
import java.time.LocalDate;
import lombok.Data;

@Data
public class WorkPermitDto {

  private Long id;
  private String assetIdentifier;

  private LocalDate workDate;
  private String workDescription;
  private String startTime;
  private Integer duration;
  private String requestedBy;
  private String approvedBy;

  public WorkPermitDto(WorkPermit workPermit) {
  }

  public String getFullAssetName() {
    return this.assetIdentifier;
  }
}
