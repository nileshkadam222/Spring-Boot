package com.nilhartech.async.controller;

import com.nilhartech.async.service.AsyncClientService;
import com.nilhartech.async.service.other.FutureWithThread;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@RestController
@Slf4j
public class AsyncController {

    @Autowired
    private AsyncClientService asyncClientService;

    @GetMapping("/one")
    public List<String> runAsyncWithCompletableFuture() throws ExecutionException, InterruptedException {

        List<CompletableFuture<String>> futuresList = IntStream.range(1, 20).boxed().map(m -> asyncClientService.getThreadNames()).collect(Collectors.toList());

        CompletableFuture<List<String>> listCompletableFuture = CompletableFuture.allOf(futuresList.toArray(new CompletableFuture[futuresList.size()]))
                .thenApply(f -> futuresList.stream().map(CompletableFuture::join).collect(Collectors.toList()));
        List<String> strings = listCompletableFuture.get();
        return strings;
    }

    @GetMapping("/two/{number}")
    public List<Integer> getDoubleNumber(@PathVariable(name = "number") Integer number) throws ExecutionException, InterruptedException {


        Future<Integer> integerFuture = new FutureWithThread().makeDouble(number);
        integerFuture.cancel(true);
        if(integerFuture.isCancelled()){
            log.info("Current operation is cancelled");
        }


        Future<Integer> future = new FutureWithThread().makeDouble(number);
        while (future.isDone()){
            log.info("in-progress");
        }
        Integer doubleNumber = future.get();


        List<Future> futures = new ArrayList<>();
        List<Future<Integer>> collect = IntStream.range(0, number).boxed().map(m -> {
            return new FutureWithThread().makeDouble(m);
        }).collect(Collectors.toList());

        return collect.stream().map(m->{
            try {
                return m.get();
            } catch (InterruptedException | ExecutionException e) {
                throw new RuntimeException(e);
            }
        }).collect(Collectors.toList());
    }
}
