package com.synctrack.condosync.service;

import com.synctrack.condosync.dto.WorkPermitDto;
import com.synctrack.condosync.model.ActiveFlagType;
import com.synctrack.condosync.model.Asset;
import com.synctrack.condosync.model.StatusType;
import com.synctrack.condosync.model.User;
import com.synctrack.condosync.model.WorkItem;
import com.synctrack.condosync.model.WorkItemType;
import com.synctrack.condosync.model.WorkPermitHistory;
import com.synctrack.condosync.repository.AssetRepository;
import com.synctrack.condosync.repository.UserRepository;
import com.synctrack.condosync.repository.WorkItemRepository;
import com.synctrack.condosync.repository.WorkPermitHistoryRepository;
import java.util.List;

import com.synctrack.condosync.model.WorkPermit;
import com.synctrack.condosync.repository.WorkPermitRepository;
import java.util.Optional;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class WorkPermitService {

  private final WorkPermitRepository workPermitRepository;
  private final WorkItemRepository workItemRepository;
  private final WorkPermitHistoryRepository workPermitHistoryRepository;
  private final UserRepository userRepository;
  private final AssetRepository assetRepository;

  public List<WorkPermitDto> getWorkPermitsForApproval() {

    List<WorkPermit> workPermits = workPermitRepository.getByClientId(1L);

    WorkPermitDto workPermitDto = new WorkPermitDto(workPermits.get(0));

    return List.of(workPermitDto);
  }

  public List<WorkPermitDto> getWorkPermitsForRequester(Long id) {
    List<WorkPermit> workPermits = workPermitRepository.getByRequestedById(id);
    return workPermits.stream().map(e -> new WorkPermitDto(e)).collect(Collectors.toList());
  }

  public WorkPermitDto getWorkPermitById(Long id) {
    return workPermitRepository.findById(id).map(WorkPermitDto::new).orElseGet(WorkPermitDto::new);
  }



  @Transactional
  public WorkPermitDto updateWorkPermit(WorkPermitDto wp) {
    workPermitRepository.updateWorkPermitFieldsById(
        wp.getId(),
        wp.getWorkDescription(),
        wp.getStatus(),
        wp.getDuration(),
        wp.getControlNo(),
        wp.getWorkDate(),
        wp.getStartTime());

    wp.getWorkers().forEach(w -> {
      if (w.getId() != null && w.getId() > 0) {
        workItemRepository.updateWorkItemCols(w.getId(), w.getItemName(), w.getActiveFlag());
      } else {
        addWorkItem(wp, w, WorkItemType.WORKER);
      }
    });

    wp.getTools().forEach(w -> {
      if (w.getId() != null && w.getId() > 0) {
        workItemRepository.updateWorkItemCols(w.getId(), w.getItemName(), w.getActiveFlag());
      } else {
        addWorkItem(wp, w, WorkItemType.TOOL);
      }
    });

    wp.getMaterials().forEach(w -> {
      if (w.getId() != null && w.getId() > 0) {
        workItemRepository.updateWorkItemCols(w.getId(), w.getItemName(), w.getActiveFlag());
      } else {
        addWorkItem(wp, w, WorkItemType.MATERIAL);
      }
    });

    return workPermitRepository
            .findById(wp.getId())
            .map(WorkPermitDto::new).orElse(null);
  }


  @Transactional
  public WorkPermitDto addWorkPermit(WorkPermitDto wp) {

    WorkPermit newWorkPermit = new WorkPermit();

    String email = ((OAuth2User) SecurityContextHolder.getContext().getAuthentication()
        .getPrincipal()).getAttribute("email");

    User requester = userRepository.findByEmail(email).orElse(null);

    Asset asset = assetRepository.findById(wp.getAssetId()).orElse(null);


    newWorkPermit.setWorkDate(wp.getWorkDate());
    newWorkPermit.setStartTime(wp.getStartTime());
    newWorkPermit.setDuration(wp.getDuration());
    newWorkPermit.setWorkDescription(wp.getWorkDescription());
    newWorkPermit.setRequestedBy(requester);
    newWorkPermit.setAsset(asset);
    newWorkPermit.setStatus(StatusType.REQUESTED.name());
    newWorkPermit.setActiveFlag(ActiveFlagType.Yes.getValue());


    workPermitRepository.save(newWorkPermit);

    wp.setId(newWorkPermit.getId());

    wp.getWorkers().forEach(w -> addWorkItem(wp, w, WorkItemType.WORKER));
    wp.getTools().forEach(w -> addWorkItem(wp, w, WorkItemType.TOOL));
    wp.getMaterials().forEach(w -> addWorkItem(wp, w, WorkItemType.MATERIAL));

    return workPermitRepository
        .findById(wp.getId())
        .map(WorkPermitDto::new).orElse(null);

  }


  public List<WorkPermitHistory> findWorkPermitHistory(long workPermitId) {
    return workPermitHistoryRepository.findHistoryByWorkPermitId(workPermitId);
  }

  private void addWorkItem(WorkPermitDto workPermit, WorkItem workItem,  WorkItemType workItemType) {
    workItem.setItemType(workItemType.name());
    workItem.setWorkPermitId(workPermit.getId());
    workItem.setActiveFlag(ActiveFlagType.Yes.getValue());
    workItemRepository.save(workItem);
  }

}
