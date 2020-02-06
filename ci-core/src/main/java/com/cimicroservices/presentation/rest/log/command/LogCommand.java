package com.cimicroservices.presentation.rest.log.command;

import lombok.Data;

@Data
public class LogCommand {
  private String message;
  private String username;
}
