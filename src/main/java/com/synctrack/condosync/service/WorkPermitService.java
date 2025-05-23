package com.synctrack.condosync.service;

import com.synctrack.condosync.dto.WorkPermitDto;
import com.synctrack.condosync.model.ActiveFlagType;
import com.synctrack.condosync.model.WorkItem;
import com.synctrack.condosync.model.WorkItemType;
import com.synctrack.condosync.repository.WorkItemRepository;
import java.util.List;

import com.synctrack.condosync.model.WorkPermit;
import com.synctrack.condosync.repository.WorkPermitRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class WorkPermitService {

  private final WorkPermitRepository workPermitRepository;
  private final WorkItemRepository workItemRepository;

  public List<WorkPermitDto> getWorkPermitsForApproval() {

    List<WorkPermit> workPermits = workPermitRepository.getByClientId(1L);

    WorkPermitDto workPermitDto = new WorkPermitDto(workPermits.get(0));

    return List.of(workPermitDto);
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

  private void addWorkItem(WorkPermitDto workPermit, WorkItem workItem,  WorkItemType workItemType) {
    workItem.setItemType(workItemType.name());
    workItem.setWorkPermitId(workPermit.getId());
    workItem.setActiveFlag(ActiveFlagType.Yes.getValue());
    workItemRepository.save(workItem);
  }

}
