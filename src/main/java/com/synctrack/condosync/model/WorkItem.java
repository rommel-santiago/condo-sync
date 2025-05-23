package com.synctrack.condosync.model;

import jakarta.persistence.*;
import java.io.Serializable;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "work_items")
@Data
public class WorkItem implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String itemType;

    private String itemName;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private String activeFlag;

    private Long workPermitId;
}
