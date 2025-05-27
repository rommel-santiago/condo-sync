package com.synctrack.condosync.controller.api;

import com.synctrack.condosync.model.Building;
import com.synctrack.condosync.service.BuildingService;
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
public class BuildingController {

  private final BuildingService buildingService;

  @GetMapping(value = "/buildings", produces = MediaType.APPLICATION_JSON_VALUE)
  public List<Building> getWorkPermitById() {
    return buildingService.getAllActiveBuildings();
  }

}
