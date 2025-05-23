package com.synctrack.condosync.repository;

import com.synctrack.condosync.model.WorkItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkItemRepository extends JpaRepository<WorkItem, Long> {

  @Modifying
  @Query("UPDATE WorkItem w SET w.itemName = :itemName, w.activeFlag = :activeFlag WHERE w.id = :id and (w.itemName <> :itemName or w.activeFlag <> :activeFlag)")
  int updateWorkItemCols(Long id, String itemName, String activeFlag);

}
