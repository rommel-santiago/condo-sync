package com.synctrack.condosync.repository;

import com.synctrack.condosync.model.WorkPermit;
import java.time.LocalDate;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface WorkPermitRepository extends JpaRepository<WorkPermit, Long> {

    @Query("select distinct wp from WorkPermit wp " +
            "join fetch wp.asset a " +
            "join fetch a.building b " +
            "join fetch b.condo c " +
            "left join fetch wp.requestedBy rb " +
            "left join fetch wp.approvedBy ab " +
            "left join fetch wp.workItems wi " +
            "where c.id = :id " +
            "and  wp.activeFlag = 'Y' " +
            "and  a.activeFlag = 'Y' " +
            "and  b.activeFlag = 'Y' " +
            "and  c.activeFlag = 'Y' " +
            "and  rb.activeFlag = 'Y' " +
            "and  ab.activeFlag = 'Y' " +
            "and  wi.activeFlag = 'Y' ")
    public List<WorkPermit> getByClientId(@Param("id") Long id);

    @Query("select distinct wp from WorkPermit wp " +
        "join wp.asset a on a.activeFlag = 'Y' " +
        "join a.building b on b.activeFlag = 'Y' " +
        "join b.condo c on c.activeFlag = 'Y' " +
        "left join wp.requestedBy rb on rb.activeFlag = 'Y' " +
        "left join wp.approvedBy ab on ab.activeFlag = 'Y'  " +
        "left join wp.workItems wi on wi.activeFlag = 'Y' " +
        "where rb.id = :id " +
        "and  wp.activeFlag = 'Y' ")
    public List<WorkPermit> getByRequestedById(@Param("id") Long id);


    @Query("select distinct wp from WorkPermit wp " +
        "join fetch wp.asset a " +
        "join fetch a.building b " +
        "join fetch b.condo c " +
        "left join fetch wp.requestedBy rb " +
        "left join fetch wp.approvedBy ab " +
        "left join fetch wp.workItems wi " +
        "where wp.id = :id " +
        "and  wp.activeFlag = 'Y' " +
        "and  a.activeFlag = 'Y' " +
        "and  b.activeFlag = 'Y' " +
        "and  c.activeFlag = 'Y' " +
        "and  rb.activeFlag = 'Y' " +
        "and  ab.activeFlag = 'Y' " +
        "and  wi.activeFlag = 'Y' ")
    public Optional<WorkPermit> findById(@Param("id") Long id);

    @Modifying
    @Query("UPDATE WorkPermit w SET w.workDescription = :workDescription, w.status = :status, w.duration = :duration, w.controlNo = :controlNo, w.workDate = :workDate, w.startTime = :startTime WHERE w.id = :id")
    int updateWorkPermitFieldsById(Long id, String workDescription, String status, Integer duration, String controlNo, LocalDate workDate, String startTime);

}
