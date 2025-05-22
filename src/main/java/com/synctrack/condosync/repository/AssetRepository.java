package com.synctrack.condosync.repository;

import com.synctrack.condosync.model.Asset;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AssetRepository  extends JpaRepository<Asset, Long> {

  @Query("select a from Asset a " +
      "join fetch a.building b " +
      "where b.id = :id")
  public List<Asset> getAssetsByBuildingId(Long id);

}
