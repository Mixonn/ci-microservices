package com.cimicroservices.core.presentation.rest;

import com.cimicroservices.core.config.TrueService;
import com.cimicroservices.core.config.WrapperService;
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

  private final WrapperService wrapperService;
  private final TrueService trueService;

  @PutMapping("/deploy")
  public Mono<DeployDTO> createDeploy(@RequestBody DeployCreateCommand deployCreateCommand) {
    return Mono.just(deployFacade.createDeploy(toDto(deployCreateCommand)));
  }

  @GetMapping("/true")
  public Mono<String> asdasd() {
    return Mono.just(trueService.getSome());
  }

  @GetMapping("/wrapper")
  public Mono<String> asdasdasd() {
    return Mono.just(wrapperService.getTrueService().getSome());
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
