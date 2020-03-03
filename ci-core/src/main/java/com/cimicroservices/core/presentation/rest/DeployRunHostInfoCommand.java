package com.cimicroservices.core.presentation.rest;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@AllArgsConstructor
@Getter
@Builder
@EqualsAndHashCode
class DeployRunHostInfoCommand {
  private String host;
  private int port;
}
