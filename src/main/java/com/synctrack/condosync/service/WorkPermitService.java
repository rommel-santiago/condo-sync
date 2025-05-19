package com.synctrack.condosync.service;

import com.synctrack.condosync.dto.WorkPermitDto;
import java.time.LocalDate;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class WorkPermitService {

  public List<WorkPermitDto> getWorkPermitsForApproval() {
    WorkPermitDto workPermitDto = new WorkPermitDto(null);
    workPermitDto.setId(100L);
    workPermitDto.setAssetIdentifier("Building: [B]  Unit: [1014]");
    workPermitDto.setDuration(5);
    workPermitDto.setStartTime("1500");
    workPermitDto.setApprovedBy("Edwin");
    workPermitDto.setRequestedBy("Rommel");
    workPermitDto.setWorkDate(LocalDate.of(2025,1,1));
    workPermitDto.setWorkDescription("Installation of WIF by PLDT Personnel");

    return List.of(workPermitDto);
  }

}
