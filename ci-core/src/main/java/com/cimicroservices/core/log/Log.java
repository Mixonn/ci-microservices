package com.cimicroservices.core.log;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(value = "logs")
@Data
@Builder
public class Log {

  @Id private String id;
  private String message;
  private String username;
}
