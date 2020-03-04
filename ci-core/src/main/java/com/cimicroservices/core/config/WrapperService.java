package com.cimicroservices.core.config;

import lombok.Data;

@Data
public class WrapperService {
  private final TrueService trueService;

  public String wrapperService() {
    return trueService.getSome();
  }
}
