package com.cimicroservices.core.presentation.rest;

import com.cimicroservices.core.core.code.DeployDTO;
import com.cimicroservices.core.core.code.DeployFacade;
import java.time.Instant;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
class DeployController {

  private final DeployFacade deployFacade;

  @PutMapping("/deploy")
  public Mono<DeployDTO> createDeploy(@RequestBody DeployCreateCommand deployCreateCommand) {
    return Mono.just(deployFacade.createDeploy(toDto(deployCreateCommand)));
  }

  @PostMapping("/deploy/{deployId}/run")
  public void runDeploy(
      @PathVariable String deployId,
      @RequestBody DeployRunHostInfoCommand deployRunHostInfoCommand) {
    deployFacade.runDeploy(
        deployId, deployRunHostInfoCommand.getHost(), deployRunHostInfoCommand.getPort());
  }

  private DeployDTO toDto(DeployCreateCommand deployCommand) {
    return DeployDTO.builder()
        .rootId(deployCommand.getRootId())
        .creationTime(Instant.now())
        .codeLanguage(deployCommand.getCodeLanguage())
        .ownerName(deployCommand.getOwnerName())
        .code(deployCommand.getCode())
        .build();
  }
}
