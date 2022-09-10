package com.async.rest;

import org.springframework.web.bind.annotation.GetMapping;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

@org.springframework.web.bind.annotation.RestController
public class RestController {

    private WebClientService webClientService;

    public RestController(WebClientService webClientService) {
        this.webClientService = webClientService;
    }

    @GetMapping
    public String get(){
        List<Integer> userList = new ArrayList<>();
        userList.add(1);
        userList.add(2);
        userList.add(3);
        userList.add(4);
        long start = System.currentTimeMillis();
        Object block = webClientService.fetchUsers(userList).collectList().block();

        return "Hi";
    }
}
