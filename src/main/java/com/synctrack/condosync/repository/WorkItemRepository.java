package com.synctrack.condosync.repository;

import com.synctrack.condosync.model.WorkItem;
import java.time.LocalDate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface WorkItemRepository extends JpaRepository<WorkItem, Long> {

  @Modifying
  @Query("UPDATE WorkItem w SET w.itemName = :itemName WHERE w.id = :id and w.itemName <> :itemName")
  int updateWorkItemName(Long id, String itemName);

}
