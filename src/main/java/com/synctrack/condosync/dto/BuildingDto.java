package com.synctrack.condosync.dto;

import com.synctrack.condosync.model.Building;
import com.synctrack.condosync.model.WorkItem;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BuildingDto {

  private Long id;
  private String buildingName;

  public BuildingDto(Building building) {
    this.id = building.getId();
    this.buildingName = building.getBuildingName();
  }

}
