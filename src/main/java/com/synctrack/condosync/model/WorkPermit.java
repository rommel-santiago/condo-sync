package com.synctrack.condosync.model;
import jakarta.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import lombok.Data;

@Entity
@Table(name = "work_permits")
@Data
public class WorkPermit implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private LocalDate workDate;

  private String workDescription;

  private String startTime;

  private Integer duration;

  private String controlNo;

  private String comment;

  private String status;

  private String activeFlag;

  @Column(insertable = false, updatable = false)
  private LocalDateTime createdAt;

  @Column(insertable = false, updatable = false)
  private LocalDateTime updatedAt;

  @OneToMany(fetch = FetchType.LAZY)
  @JoinColumn(name="workPermitId", referencedColumnName ="id")
  private List<WorkItem> workItems;

  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "requested_by_id", nullable = false)
  private User requestedBy;

  @ManyToOne(fetch = FetchType.LAZY, optional = true)
  @JoinColumn(name = "approved_by_id", nullable = true)
  private User approvedBy;

  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "asset_id", nullable = false)
  private Asset asset;

}
