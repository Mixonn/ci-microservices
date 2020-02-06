package com.cimicroservices.presentation.rest.log;

import com.cimicroservices.core.log.Log;
import com.cimicroservices.core.log.LogService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/log")
@RequiredArgsConstructor
class LogController {

  private final LogService logService;

  @GetMapping("/{user}")
  Flux<Log> getAllUserLogs(@PathVariable String user) {
    return logService.getAllUserLogs(user);
  }

  @PostMapping
  Mono<Log> addLog(@RequestBody CreateLogCommand logCommand) {
    return logService.addLog(logCommand.getUsername(), logCommand.getMessage());
  }
}
