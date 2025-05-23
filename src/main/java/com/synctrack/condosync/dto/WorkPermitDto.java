package com.synctrack.condosync.dto;

import com.synctrack.condosync.model.Asset;
import com.synctrack.condosync.model.Building;
import com.synctrack.condosync.model.User;
import com.synctrack.condosync.model.WorkItem;
import com.synctrack.condosync.model.WorkItemType;
import com.synctrack.condosync.model.WorkPermit;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import java.util.Optional;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;

@Data
@NoArgsConstructor
public class WorkPermitDto {

  private Long id;
  private LocalDate workDate;
  private String workDescription;
  private String startTime;
  private Integer duration;
  private String controlNo;
  private String status;

  private long assetId;
  private String assetFullName;

  private long requesterId;
  private String requesterName;

  private long approverId;
  private String approverName;


  private List<WorkItem> workers = new ArrayList<>();
  private List<WorkItem> tools = new ArrayList<>();
  private List<WorkItem> materials = new ArrayList<>();

  public WorkPermitDto(WorkPermit workPermit) {

    this.id = workPermit.getId();
    this.workDate = workPermit.getWorkDate();
    this.workDescription = workPermit.getWorkDescription();
    this.startTime = workPermit.getStartTime();
    this.duration = workPermit.getDuration();
    this.controlNo = workPermit.getControlNo();
    this.status = workPermit.getStatus();

    this.assetId = (workPermit.getAsset() != null) ? workPermit.getAsset().getId() : null;
    this.assetFullName = getAssetFullName(workPermit.getAsset());
    this.requesterId = (workPermit.getRequestedBy() != null) ? workPermit.getRequestedBy().getId() : null;
    this.requesterName = getFullName(workPermit.getRequestedBy());
    this.approverId = (workPermit.getApprovedBy() != null) ? workPermit.getApprovedBy().getId() : null;
    this.approverName = getFullName(workPermit.getApprovedBy());

    workPermit.getWorkItems().forEach(i -> {
      switch (WorkItemType.fromString(i.getItemType())) {
        case WORKER:
          workers.add(i);
          break;
        case TOOL:
          tools.add(i);
          break;
        case MATERIAL:
          materials.add(i);
          break;
        default:
          break;
      }
    });
  }

  public String getAssetFullName(Asset asset) {
    if (asset == null) {
      return "";
    }
    String assetIdentifier = StringUtils.trimToEmpty(asset.getAssetIdentifier());
    String buildingName = Optional.ofNullable(asset.getBuilding())
        .map(Building::getBuildingName)
        .filter(StringUtils::isNotEmpty)
        .orElse("");

    if (StringUtils.isNotEmpty(buildingName)) {
      return buildingName + (StringUtils.isNotEmpty(assetIdentifier) ? " [" + assetIdentifier + "]" : "");
    }

    return assetIdentifier;
  }

  public String getFormattedDateTime() {
    if (workDate == null) {
      return "";
    }

    String formattedDate = DateTimeFormatter.ofPattern("yyyy-MMM-dd").format(workDate);

    if (StringUtils.isNotEmpty(startTime) && startTime.matches("\\d{4}")) {
      String formattedTime = startTime.substring(0, 2) + ":" + startTime.substring(2);
      return formattedDate + " " + formattedTime;
    }

    return formattedDate;
  }

  public String getFullName(User user) {

    String requesterName = "";

    if (Objects.nonNull(user)) {
      requesterName = StringUtils.trimToEmpty(user.getLastName());
      if (StringUtils.isNotEmpty(requesterName)) {
        requesterName = requesterName.concat(", ")
            .concat(StringUtils.trimToEmpty(user.getFirstName()));
      } else {
        requesterName = StringUtils.trimToEmpty(user.getFirstName());
      }

      if (StringUtils.isNotEmpty(requesterName)) {
        requesterName = requesterName.concat(" ")
            .concat(StringUtils.trimToEmpty(user.getMiddleInitial()));
      } else {
        requesterName = StringUtils.trimToEmpty(user.getMiddleInitial());
      }
    }

    return requesterName;
  }

}
