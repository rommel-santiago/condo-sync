package com.synctrack.condosync.model;

import jakarta.persistence.*;
import java.io.Serializable;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "condos")
@Data
public class Condo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String condoName;

    private String address;

    private String city;

    private String stateRegion;

    private String postalCode;

    private String comment;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private String status;

    private String activeFlag;
}
