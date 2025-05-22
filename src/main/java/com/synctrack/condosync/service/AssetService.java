package com.synctrack.condosync.service;

import com.synctrack.condosync.dto.AssetDto;
import com.synctrack.condosync.dto.BuildingDto;
import com.synctrack.condosync.model.Status;
import com.synctrack.condosync.repository.AssetRepository;
import com.synctrack.condosync.repository.BuildingRepository;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AssetService {
  private final AssetRepository assetRepository;

  public List<AssetDto> getAllAssetsByBuildingId(Long buildingId) {
    return assetRepository
        .getAssetsByBuildingId(buildingId).stream()
        .map(AssetDto::new)
        .collect(Collectors.toList());

  }

}
