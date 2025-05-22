package com.synctrack.condosync.repository;

import com.synctrack.condosync.model.WorkPermit;
import java.time.LocalDate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface WorkPermitRepository extends JpaRepository<WorkPermit, Long> {

    @Query("select wp from WorkPermit wp " +
            "join fetch wp.asset a " +
            "join fetch a.building b " +
            "join fetch b.condo c " +
            "left join fetch wp.requestedBy rb " +
            "left join fetch wp.approvedBy ab " +
            "left join fetch wp.workItems wi " +
            "where c.id = :id " +
            "and  wp.status = 'ACTIVE' " +
            "and  a.status = 'ACTIVE' " +
            "and  b.status = 'ACTIVE' " +
            "and  c.status = 'ACTIVE' " +
            "and  rb.status = 'ACTIVE' " +
            "and  ab.status = 'ACTIVE' " +
            "and  wi.status = 'ACTIVE' ")
    public List<WorkPermit> getByClientId(@Param("id") Long id);


    @Modifying
    @Query("UPDATE WorkPermit w SET w.workDescription = :workDescription, w.status = :status, w.duration = :duration, w.controlNo = :controlNo, w.workDate = :workDate, w.startTime = :startTime WHERE w.id = :id")
    int updateWorkPermitFieldsById(Long id, String workDescription, String status, Integer duration, String controlNo, LocalDate workDate, String startTime);

}
