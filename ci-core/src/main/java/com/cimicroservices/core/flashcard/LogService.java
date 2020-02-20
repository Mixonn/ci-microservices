package com.cimicroservices.core.flashcard;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@Service
public class LogService {

//  private final FlashCardRepository logRepository;
//
//  public Mono<FlashCard> addLog(String username, String message) {
//    return logRepository.save(FlashCard.builder().message(message).username(username).build());
//  }
//
//  public Flux<FlashCard> getAllUserLogs(String username) {
//    return logRepository.findAllByUsername(username);
//  }
}
