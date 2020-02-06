package com.cimicroservices.presentation.rest.log;

import lombok.Data;

@Data
class CreateLogCommand {
  private String message;
  private String username;
}
