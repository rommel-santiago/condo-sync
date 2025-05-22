package com.synctrack.condosync.service;

import com.synctrack.condosync.dto.BuildingDto;
import com.synctrack.condosync.model.Building;
import com.synctrack.condosync.model.Status;
import com.synctrack.condosync.repository.BuildingRepository;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BuildingService {

  private final BuildingRepository repository;

  public List<BuildingDto> getAllActiveBuildings() {
    return repository
        .findAllByStatus(Status.ACTIVE.name()).stream()
        .map(BuildingDto::new)
        .collect(Collectors.toList());

  }
}
