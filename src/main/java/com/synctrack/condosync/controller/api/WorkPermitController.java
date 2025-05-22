package com.synctrack.condosync.controller.api;

import com.synctrack.condosync.dto.WorkPermitDto;
import com.synctrack.condosync.service.WorkPermitService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class WorkPermitController {

  private final WorkPermitService workPermitService;

  @GetMapping(value = "/workPermit/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
  public WorkPermitDto getWorkPermitById(@PathVariable("id") long id) {
    return workPermitService.getWorkPermitById(id);
  }


}
