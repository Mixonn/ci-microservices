package com.cimicroservices.core.code;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeployFacade {
  private final DeployRunService deployRunService;

  public DeployDTO createDeploy(DeployDTO deployDTO) {
    return toDto(deployRunService.createDeploy(fromDto(deployDTO)));
  }

  public void runDeploy(String deployId, String host, int port) {
    deployRunService.runDeploy(deployId, host, port);
  }

  private DeployDTO toDto(Deploy deploy) {
    return DeployDTO.builder()
        .rootId(deploy.getRootId())
        .creationTime(deploy.getCreationTime())
        .codeLanguage(deploy.getCodeLanguage())
        .ownerName(deploy.getOwnerName())
        .code(deploy.getCode())
        .build();
  }

  private Deploy fromDto(DeployDTO deployDTO) {
    return Deploy.builder()
        .rootId(deployDTO.getRootId())
        .creationTime(deployDTO.getCreationTime())
        .codeLanguage(deployDTO.getCodeLanguage())
        .ownerName(deployDTO.getOwnerName())
        .code(deployDTO.getCode())
        .build();
  }
}
