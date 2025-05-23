package com.synctrack.condosync.model;

import jakarta.persistence.*;
import java.io.Serializable;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "buildings")
@Data
public class Building implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String buildingName;

    private String comment;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private String activeFlag;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "condoId", nullable = false)
    private Condo condo;

}
