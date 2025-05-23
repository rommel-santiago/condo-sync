package com.synctrack.condosync.repository;

import com.synctrack.condosync.model.Building;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BuildingRepository extends JpaRepository<Building, Long> {


  @Query("select b from Building b " +
      "join fetch b.condo c " +
      "where b.activeFlag = 'Y' " +
      "and   b.activeFlag = 'Y' " +
      "order by b.buildingName")
  List<Building> findAllActiveBuildings();

}
