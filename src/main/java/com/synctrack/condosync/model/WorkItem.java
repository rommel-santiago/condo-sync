package com.synctrack.condosync.model;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "work_items")
@Data
public class WorkItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "item_type", nullable = false, length = 20)
    private String itemType;

    @Column(name = "item_name", nullable = false, length = 255)
    private String itemName;

    @Column(name = "created_at", insertable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at", insertable = false)
    private LocalDateTime updatedAt;

    @Column(name = "status", length = 20)
    private String status;

    @Column(name = "work_permit_id", nullable = false)
    private Long workPermitId;
}
