package com.cimicroservices.core.core.code;

import com.cimicroservices.core.core.code.deploy.DeployRunService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class DeployFacade {
  private final DeployRunService deployRunService;

  public DeployDTO createDeploy(DeployDTO deployDTO) {
    return deployRunService.createDeploy(deployDTO);
  }

  public Mono<String> runDeploy(String deployId, String host, int port) {
    return deployRunService.runDeploy(deployId, host, port);
  }
}
