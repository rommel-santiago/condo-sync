package com.synctrack.condosync.playground;

import com.synctrack.condosync.repository.ResidentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Initial implements ApplicationListener<ContextRefreshedEvent> {

  private final ResidentRepository residentRepository;

  @Override
  public void onApplicationEvent(ContextRefreshedEvent event) {

    residentRepository.findAll();

  }
}
