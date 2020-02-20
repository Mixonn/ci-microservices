package com.cimicroservices.core.flashcard;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(value = "flashCard")
@Data
@Builder
public class FlashCard<T extends FlashCardSite, S extends FlashCardSite> {

  @Id private String id;
  private String owner;
  private T frontSite;
  private S backSite;
}
