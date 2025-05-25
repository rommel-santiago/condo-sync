package com.synctrack.condosync.repository;

import com.synctrack.condosync.model.WorkPermit;
import com.synctrack.condosync.model.WorkPermitHistory;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface WorkPermitHistoryRepository extends JpaRepository<WorkPermitHistory, Long> {

  @Query("select wph from WorkPermitHistory wph " +
      "join fetch wph.user u " +
      "where wph.id = :id " +
      "and  wph.activeFlag = 'Y' " +
      "and  u.activeFlag = 'Y' ")
  public List<WorkPermitHistory> findHistoryByWorkPermitId(@Param("id") Long id);

}
