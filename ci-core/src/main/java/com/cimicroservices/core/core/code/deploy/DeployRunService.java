package com.cimicroservices.core.core.code.deploy;

import com.cimicroservices.core.core.code.DeployDTO;
import com.cimicroservices.core.core.code.ExternalServiceException;
import java.time.Duration;
import lombok.Builder;
import lombok.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class DeployRunService {

  private final WebClient webClient;

  DeployRunService(WebClient.Builder webClientBuilder) {
    this.webClient = webClientBuilder.build();
  }

  public Mono<String> runDeploy(String deployRootId, String host, int port) {
    return webClient
        .post()
        .uri("http://app-deploy-runner/run/{deployId}", deployRootId)
        .body(BodyInserters.fromValue(new RunDeployDTO(host, port)))
        .retrieve()
        .onStatus(
            HttpStatus::isError,
            response ->
                Mono.error(
                    new ExternalServiceException(
                        "app-deploy-runner",
                        response.rawStatusCode(),
                        "",
                        "External service error")))
        .bodyToMono(String.class)
        .timeout(Duration.ofMillis(2000));
  }

  public DeployDTO createDeploy(DeployDTO deployToCreate) {
    return deployToCreate; // todo change it
  }

  @Value
  @Builder
  private static class RunDeployDTO {
    String host;
    int port;
  }
}
