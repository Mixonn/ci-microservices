package com.cimicroservices.core.code;

import java.time.Instant;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
class Deploy {
  private String rootId;
  private Instant creationTime;
  private CodeLanguage codeLanguage;
  private String ownerName;
  private String code;
}
