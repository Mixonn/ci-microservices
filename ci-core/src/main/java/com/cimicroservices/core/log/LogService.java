package com.cimicroservices.core.log;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@Service
public class LogService {

  private final LogRepository logRepository;

  public Mono<Log> addLog(String username, String message) {
    return logRepository.save(Log.builder().message(message).username(username).build());
  }

  public Flux<Log> getAllUserLogs(String username) {
    return logRepository.findAllByUsername(username);
  }
}
