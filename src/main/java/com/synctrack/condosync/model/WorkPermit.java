package com.synctrack.condosync.model;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import lombok.Data;

@Entity
@Table(name = "work_permits")
@Data
public class WorkPermit {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "asset_id", nullable = false)
  private Long assetId;

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

  @Column(name = "requested_by", nullable = false)
  private Long requestedBy;

  @Column(name = "approved_by", nullable = false)
  private Long approvedBy;

  @Column(name = "created_at", updatable = false)
  private LocalDateTime createdAt;

  @Column(name = "updated_at")
  private LocalDateTime updatedAt;


}
