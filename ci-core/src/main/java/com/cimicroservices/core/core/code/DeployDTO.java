package com.cimicroservices.core.core.code;

import java.time.Instant;
import lombok.*;

@Value
@Builder
public class DeployDTO {
  String rootId;
  Instant creationTime;
  CodeLanguage codeLanguage;
  String ownerName;
  String code;
}
