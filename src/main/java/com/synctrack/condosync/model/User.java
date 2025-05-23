package com.synctrack.condosync.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "users")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String lastName;

    private String firstName;

    private String middleInitial;

    private String email;

    private String phoneNumber;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private String userType;

    private LocalDate fromDate;

    private LocalDate toDate;

    private Long addedBy;

    private Long approvedBy;

    private String comment;

    private String status;

    private String activeFlag;
}
