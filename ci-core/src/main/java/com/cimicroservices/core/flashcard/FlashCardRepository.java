package com.cimicroservices.core.flashcard;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlashCardRepository extends ReactiveMongoRepository<FlashCard<? extends FlashCardSite, ? extends FlashCardSite>, String> {
}
