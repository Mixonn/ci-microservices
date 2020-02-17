package com.cimicroservices.presentation.rest.log;

import com.cimicroservices.core.log.Log;
import com.cimicroservices.core.log.LogService;
import io.micrometer.core.annotation.Timed;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/log")
@RequiredArgsConstructor
@Timed(value = "logCustom")
class LogController {

  private final LogService logService;

  @GetMapping("/{user}")
  @Timed(
      value = "logCustom.get",
      histogram = true,
      percentiles = {0.5, 0.9, 0.99})
  public Flux<Log> getAllUserLogs(@PathVariable String user) {
    return logService.getAllUserLogs(user);
  }

  @PostMapping
  @Timed(
      value = "logCustom.add",
      histogram = true,
      percentiles = {0.5, 0.9, 0.99})
  public Mono<Log> addLog(@RequestBody CreateLogCommand logCommand) {
    return logService.addLog(logCommand.getUsername(), logCommand.getMessage());
  }
}
