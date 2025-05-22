package com.synctrack.condosync.repository;

import com.synctrack.condosync.model.Building;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BuildingRepository extends JpaRepository<Building, Long> {

  List<Building> findAllByStatus(String status);

}
