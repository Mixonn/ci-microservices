package com.cimicroservices.core.core.code;

import java.time.Duration;
import lombok.Builder;
import lombok.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
class DeployRunService {

  private final WebClient webClient;

  DeployRunService(WebClient.Builder webClientBuilder) {
    this.webClient = webClientBuilder.build();
  }

  Mono<String> runDeploy(String deployRootId, String host, int port) {
    return webClient
        .post()
        .uri("http://app-deploy-runner/run/{deployId}", deployRootId)
        .body(BodyInserters.fromValue(new RunDeployDTO(host, port)))
        .retrieve()
        .bodyToMono(String.class)
        .timeout(Duration.ofMillis(1000));
  }

  public Deploy createDeploy(Deploy fromDto) {
    return fromDto; // todo change it
  }

  @Value
  @Builder
  private static class RunDeployDTO {
    String host;
    int port;
  }
}
