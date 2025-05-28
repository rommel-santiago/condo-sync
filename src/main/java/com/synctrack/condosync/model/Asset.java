package com.synctrack.condosync.model;

import jakarta.persistence.*;
import java.io.Serializable;
import lombok.Data;

import java.time.LocalDateTime;
import org.hibernate.annotations.Where;

@Entity
@Table(name = "assets")
@Data
public class Asset implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String assetIdentifier;

    private int floor;

    private String comment;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private String assetType;

    private String status;

    private String activeFlag;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "building_id", nullable = false)
    private Building building;
}
