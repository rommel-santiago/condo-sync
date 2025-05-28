package com.synctrack.condosync.controller.api;

import com.synctrack.condosync.dto.WorkPermitDto;
import com.synctrack.condosync.model.WorkPermitHistory;
import com.synctrack.condosync.service.WorkPermitService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/")
public class WorkPermitController {

  private final WorkPermitService workPermitService;

  @GetMapping(value = "/workPermit/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
  public WorkPermitDto getWorkPermitById(@PathVariable("id") long id) {
    return workPermitService.getWorkPermitById(id);
  }

  @PostMapping(value = "/workPermit/add", produces = MediaType.APPLICATION_JSON_VALUE)
  public WorkPermitDto addWorkPermit(@RequestBody WorkPermitDto workPermitDto) {

    return workPermitService.addWorkPermit(workPermitDto);
  }
  @PostMapping(value = "/workPermit/update", produces = MediaType.APPLICATION_JSON_VALUE)
  public WorkPermitDto updateWorkPermit(@RequestBody WorkPermitDto workPermitDto) {

    return workPermitService.updateWorkPermit(workPermitDto);
  }

  @GetMapping(value = "/workPermit/history/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
  public List<WorkPermitHistory> getWorkPermitHistory(@PathVariable("id") long id) {
    return workPermitService.findWorkPermitHistory(id);
  }

}
