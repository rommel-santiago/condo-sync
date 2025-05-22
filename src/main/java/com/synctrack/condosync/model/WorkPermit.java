package com.synctrack.condosync.model;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import lombok.Data;

@Entity
@Table(name = "work_permits")
@Data
public class WorkPermit {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "work_date", nullable = false)
  private LocalDate workDate;

  @Column(name = "work_description", nullable = false, length = 512)
  private String workDescription;

  @Column(name = "start_time", nullable = false, length = 4)
  private String startTime;

  @Column(nullable = false)
  private Integer duration;

  @Column(name = "control_no", length = 20)
  private String controlNo;

  @Column(length = 512)
  private String comment;

  @Column(nullable = false, length = 20)
  private String status;

  @Column(name = "created_at", updatable = false)
  private LocalDateTime createdAt;

  @Column(name = "updated_at")
  private LocalDateTime updatedAt;

  @OneToMany(fetch = FetchType.LAZY)
  @JoinColumn(name="work_permit_id", referencedColumnName ="id")
  private List<WorkItem> workItems;

  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "requested_by_id", nullable = false)
  private User requestedBy;

  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "approved_by_id", nullable = false)
  private User approvedBy;

  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "asset_id", nullable = false)
  private Asset asset;

}
