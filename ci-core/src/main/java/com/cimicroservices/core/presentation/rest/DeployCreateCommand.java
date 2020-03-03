package com.cimicroservices.core.presentation.rest;

import com.cimicroservices.core.core.code.CodeLanguage;
import lombok.*;

@Value
@Builder
class DeployCreateCommand {
  String rootId;
  CodeLanguage codeLanguage;
  String ownerName; // todo should fetch from token
  String code;
}
