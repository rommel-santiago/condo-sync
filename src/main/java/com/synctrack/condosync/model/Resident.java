package com.synctrack.condosync.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDate;
import java.time.LocalDateTime;
import lombok.Data;

@Entity
@Table(name = "residents")
@Data
public class Resident {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "last_name", nullable = false, length = 100)
  private String lastName;

  @Column(name = "first_name", nullable = false, length = 100)
  private String firstName;

  @Column(name = "middle_initial", length = 1)
  private String middleInitial;

  @Column(name = "email", length = 100)
  private String email;

  @Column(name = "phone_number", length = 30)
  private String phoneNumber;

  @Column(name = "created_at", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
  private LocalDateTime createdAt;

  @Column(name = "updated_at", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
  private LocalDateTime updatedAt;

  @Column(name = "resident_type", nullable = false, length = 20)
  private String residentType;

  @Column(name = "from_date")
  private LocalDate fromDate;

  @Column(name = "to_date")
  private LocalDate toDate;

  @Column(name = "added_by")
  private Long addedBy;

  @Column(name = "approved_by")
  private Long approvedBy;

  @Column(name = "comment", length = 512)
  private String comment;

  @Column(name = "status", length = 20)
  private String status;

}
