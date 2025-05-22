package com.synctrack.condosync.service;

import com.synctrack.condosync.dto.WorkPermitDto;
import java.time.LocalDate;
import java.util.List;

import com.synctrack.condosync.model.WorkPermit;
import com.synctrack.condosync.repository.WorkPermitRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WorkPermitService {

  private final WorkPermitRepository workPermitRepository;

  public List<WorkPermitDto> getWorkPermitsForApproval() {

    List<WorkPermit> workPermits = workPermitRepository.getByClientId(1L);

    WorkPermitDto workPermitDto = new WorkPermitDto(workPermits.get(0));

    return List.of(workPermitDto);
  }

  public WorkPermitDto getWorkPermitById(Long id) {
    return workPermitRepository.findById(id).map(WorkPermitDto::new).orElseGet(WorkPermitDto::new);
  }

}
