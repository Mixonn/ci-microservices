package com.cimicroservices.core.core.code;

public class ExternalServiceException extends RuntimeException {
  private String service;
  private int responseCode;
  private String responseMessage;
  private String message;

  public ExternalServiceException(
      String service, int responseCode, String responseMessage, String message) {
    this.service = service;
    this.responseCode = responseCode;
    this.responseMessage = responseMessage;
    this.message = message;
  }
}
