package com.synctrack.condosync.service;

import com.synctrack.condosync.model.Building;
import com.synctrack.condosync.model.StatusType;
import com.synctrack.condosync.repository.BuildingRepository;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BuildingService {

  private final BuildingRepository repository;

  public List<Building> getAllActiveBuildings() {
    return new ArrayList<>(repository
        .findAllActiveBuildings());

  }
}
