package com.reactive.repo;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;
import com.reactive.model.Taco;

public interface TacoRepository
    extends ReactiveMongoRepository<Taco, String> {
    Flux<Taco> findByOrderByCreatedAtDesc();
}