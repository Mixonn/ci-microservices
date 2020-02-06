package com.cimicroservices.presentation.rest.log;

import com.cimicroservices.core.log.Log;
import com.cimicroservices.core.log.LogService;
import com.cimicroservices.presentation.rest.log.command.LogCommand;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
public class LogController {

  private final LogService logService;

  @GetMapping("/{user}")
  Flux<Log> getAllUserLogs(@PathVariable String user) {
    return logService.getAllUserLogs(user);
  }

  @PostMapping
  Mono<Log> addLog(@RequestBody LogCommand logCommand) {
    return logService.addLog(logCommand.getUsername(), logCommand.getMessage());
  }
}
