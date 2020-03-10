package com.cimicroservices.core.presentation.rest;

import com.cimicroservices.core.core.code.DeployDTO;
import com.cimicroservices.core.core.code.DeployFacade;
import java.time.Instant;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@Slf4j
class DeployController {

  private final DeployFacade deployFacade;

  @PutMapping("/deploy")
  public Mono<DeployDTO> createDeploy(@RequestBody DeployCreateCommand deployCreateCommand) {
    return Mono.just(deployFacade.createDeploy(toDto(deployCreateCommand)));
  }

  @PostMapping("/deploy/{deployId}/run")
  public Mono<String> runDeploy(
      @PathVariable String deployId,
      @RequestBody DeployRunHostInfoCommand deployRunHostInfoCommand) {
    return deployFacade.runDeploy(
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
