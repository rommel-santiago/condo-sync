package com.synctrack.condosync.controller.api;

import com.synctrack.condosync.model.Asset;
import com.synctrack.condosync.service.AssetService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/")
public class AssetController {

  private final AssetService assetService;

  @GetMapping(value = "/assets/{buildingId}", produces = MediaType.APPLICATION_JSON_VALUE)
  public List<Asset> getAssetsByBuildingId(@PathVariable("buildingId") Long buildingId) {
    return assetService.getAllAssetsByBuildingId(buildingId);
  }

}
