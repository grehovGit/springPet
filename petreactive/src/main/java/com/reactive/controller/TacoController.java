package com.reactive.controller;

import com.reactive.model.Taco;
import com.reactive.repo.TacoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(path = "/taco", produces = "application/json")
@CrossOrigin(origins = "*")
public class TacoController {
    private TacoRepository tacoRepo;

    public TacoController(TacoRepository tacoRepo) {
        this.tacoRepo = tacoRepo;
    }

    @GetMapping("/recent")
    public Flux<Taco> recentTacos() {
        return tacoRepo.findAll().take(12);
    }

    @PostMapping(consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Taco> postTaco(@RequestBody Taco taco) {
        return tacoRepo.save(taco);
    }

    @GetMapping("/{id}")
    public Mono<Taco> tacoById(@PathVariable("id") String id) {
        return tacoRepo.findById(id);
    }

}