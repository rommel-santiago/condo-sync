package com.synctrack.condosync.repository;

import com.synctrack.condosync.model.WorkPermit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

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
            "where wp.id = :id")
    public List<WorkPermit> getByClientId(@Param("id") Long id);


}
