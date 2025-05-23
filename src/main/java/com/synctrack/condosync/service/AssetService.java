package com.synctrack.condosync.service;

import com.synctrack.condosync.model.Asset;
import com.synctrack.condosync.repository.AssetRepository;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AssetService {
  private final AssetRepository assetRepository;

  public List<Asset> getAllAssetsByBuildingId(Long buildingId) {
    return new ArrayList<>(assetRepository
        .getAssetsByBuildingId(buildingId));
  }

}
