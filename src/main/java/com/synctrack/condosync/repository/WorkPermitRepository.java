package com.synctrack.condosync.repository;

import com.synctrack.condosync.model.WorkPermit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkPermitRepository extends JpaRepository<WorkPermit, Long> {

}
