package com.synctrack.condosync.dto;

import com.synctrack.condosync.model.Asset;
import com.synctrack.condosync.model.Building;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AssetDto {

  public Long id;
  public String assetIdentifier;

  public AssetDto(Asset asset) {
    this.id = asset.getId();
    this.assetIdentifier = asset.getAssetIdentifier();
  }

}
