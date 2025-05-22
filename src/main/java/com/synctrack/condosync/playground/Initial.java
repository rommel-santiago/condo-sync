package com.synctrack.condosync.playground;

import com.synctrack.condosync.dto.WorkPermitDto;
import com.synctrack.condosync.model.WorkPermit;
import com.synctrack.condosync.repository.AssetRepository;
import com.synctrack.condosync.repository.ResidentRepository;
import com.synctrack.condosync.repository.WorkPermitRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Initial implements ApplicationListener<ContextRefreshedEvent> {

  private final ResidentRepository residentRepository;
  private final WorkPermitRepository workPermitRepository;

  private final AssetRepository assetRepository;

  @Override
  public void onApplicationEvent(ContextRefreshedEvent event) {
    WorkPermit wp = workPermitRepository.getByClientId(1L).get(0);

    WorkPermitDto dto = new WorkPermitDto(wp);



    residentRepository.findAll();

  }
}
