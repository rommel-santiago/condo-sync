package com.synctrack.condosync.dto;

import com.synctrack.condosync.model.Asset;
import com.synctrack.condosync.model.Building;
import com.synctrack.condosync.model.User;
import com.synctrack.condosync.model.WorkPermit;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

import jakarta.persistence.Column;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class WorkPermitDto {

  private Long id;
  private String assetIdentifier;
  private String buildingName;

  private LocalDate workDate;
  private String workDescription;
  private String startTime;
  private Integer duration;
  private String controlNo;
  private String status;
  private String requestedBy;
  private String approvedBy;
  private Long approvedById;

  public WorkPermitDto(WorkPermit workPermit) {

    Asset asset = workPermit.getAsset();
    Building building = Objects.nonNull(asset) ? asset.getBuilding() : null;
    User requestedBy = workPermit.getRequestedBy();
    User approvedBy = workPermit.getApprovedBy();

    this.id = workPermit.getId();
    this.workDate = workPermit.getWorkDate();
    this.workDescription = workPermit.getWorkDescription();
    this.startTime = workPermit.getStartTime();
    this.duration = workPermit.getDuration();
    this.controlNo = workPermit.getControlNo();
    this.status = workPermit.getStatus();

    this.assetIdentifier = Objects.nonNull(asset) ? asset.getAssetIdentifier() : null;
    this.buildingName = building.getBuildingName();

    this.approvedBy = Objects.nonNull(approvedBy) ? approvedBy.getLastName() : null;
    this.approvedById = Objects.nonNull(approvedBy) ? approvedBy.getId() : null;

    this.requestedBy = Objects.nonNull(requestedBy) ? requestedBy.getLastName() : null;


  }

}
