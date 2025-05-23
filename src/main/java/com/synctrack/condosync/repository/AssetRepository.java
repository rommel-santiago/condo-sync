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
      "join fetch b.condo c " +
      "where b.id = :id " +
      "and a.activeFlag = 'Y' " +
      "and b.activeFlag = 'Y' " +
      "and c.activeFlag = 'Y' " +
      "order by a.assetIdentifier ")
  public List<Asset> getAssetsByBuildingId(Long id);

}
