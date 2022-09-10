package com.async.rest;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;


@Service
public class WebClientService {

    private WebClient webClient;

    public WebClientService() {
        this.webClient = WebClient.create("https://reqres.in");
    }

    public Flux fetchUsers(List<Integer> userIds) {
        return Flux.fromIterable(userIds)
                .flatMap(this::getUser);
    }

    public Mono<String> getUser(int id) {
        return webClient.get()
                .uri("/api/users", id)
                .retrieve()
                .bodyToMono(String.class);
    }
}
