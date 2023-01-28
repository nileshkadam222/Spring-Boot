package com.nilhartech.async.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

@Service
@Slf4j
public class AsyncClientService {


    @Async
    public CompletableFuture<String> getThreadNames(){
        log.info(Thread.currentThread().getName());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        String name = Thread.currentThread().getName();
        return CompletableFuture.completedFuture(name);
    }

    @Async
    public Future<String> getThreadNamesFuture(){
        log.info(Thread.currentThread().getName());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        String name = Thread.currentThread().getName();
        return new AsyncResult<String>(name);
    }

}
