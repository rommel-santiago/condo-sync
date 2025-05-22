package com.synctrack.condosync.dto;

import com.synctrack.condosync.model.WorkItem;
import com.synctrack.condosync.model.WorkPermit;
import lombok.Data;

@Data
public class WorkItemDto {
  private long id;
  private String name;

  public WorkItemDto(WorkItem item) {
    this.id = item.getId();
    this.name = item.getItemName();
  }
}
