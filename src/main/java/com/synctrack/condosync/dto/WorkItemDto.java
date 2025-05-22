package com.synctrack.condosync.dto;

import com.synctrack.condosync.model.WorkItem;
import com.synctrack.condosync.model.WorkPermit;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class WorkItemDto {
  private Long id;
  private String name;
  private String status;

  public WorkItemDto(WorkItem item) {
    this.id = item.getId();
    this.name = item.getItemName();
    this.status = item.getStatus();
  }
}
