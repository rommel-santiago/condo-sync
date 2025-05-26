package com.synctrack.condosync.controller.ui;

import com.synctrack.condosync.dto.WorkPermitDto;
import com.synctrack.condosync.service.WorkPermitService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@RequiredArgsConstructor
public class CondoController {

  private final WorkPermitService workPermitService;

  @GetMapping("/")
  public String home() {
    return "home/home";
  }

  @GetMapping("/units")
  public String units() {
    return "units/units";
  }

  @GetMapping("/residents")
  public String residents() {
    return "residents/residents";
  }

  @GetMapping("/workPermits/forApprovals")
  public String workPermitsForApproval(Model model) {
    List<WorkPermitDto> workPermitDtos = workPermitService.getWorkPermitsForApproval();
    model.addAttribute("workPermits", workPermitDtos);
    return "workPermits/forApprovals";
  }

  @GetMapping("/workPermits/forUser/{id}")
  public String workPermitsForUser(@PathVariable("id") Long id, Model model) {
    List<WorkPermitDto> workPermitDtos = workPermitService.getWorkPermitsForApproval();
    model.addAttribute("workPermits", workPermitDtos);
    return "workPermits/forApprovals";
  }

  @GetMapping("/workPermits/approved")
  public String workPermitsApproved(Model model) {
    List<WorkPermitDto> workPermitDtos = workPermitService.getWorkPermitsForApproval();
    model.addAttribute("permits", workPermitDtos);
    return "workPermits/approved";
  }

  @GetMapping("/gatePass")
  public String gatePass() {
    return "gatePass/gatePass";
  }

  @GetMapping("/bookFacility")
  public String bookFacility() {
    return "bookFacility/bookFacility";
  }
  @GetMapping("/maintenanceRequests")
  public String maintenanceRequests() {
    return "maintenanceRequests/maintenanceRequests";
  }

  @GetMapping("/about")
  public String about() {
    return "about";
  }

  @GetMapping("/contact")
  public String contact() {
    return "contact";
  }

  @GetMapping("/userMainMenu")
  public String userMainMenu() {
    return "userMainMenu";
  }

}
