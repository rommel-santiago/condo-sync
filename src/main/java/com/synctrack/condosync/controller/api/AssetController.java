package com.synctrack.condosync.controller.api;

import com.synctrack.condosync.dto.AssetDto;
import com.synctrack.condosync.dto.BuildingDto;
import com.synctrack.condosync.repository.AssetRepository;
import com.synctrack.condosync.service.AssetService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AssetController {

  private final AssetService assetService;

  @GetMapping(value = "/assets/{buildingId}", produces = MediaType.APPLICATION_JSON_VALUE)
  public List<AssetDto> getAssetsByBuildingId(@PathVariable("buildingId") Long buildingId) {
    return assetService.getAllAssetsByBuildingId(buildingId);
  }

}
