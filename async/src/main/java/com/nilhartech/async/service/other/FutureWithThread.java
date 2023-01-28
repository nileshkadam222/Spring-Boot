package com.nilhartech.async.service.other;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureWithThread {
    private ExecutorService executor
            = Executors.newFixedThreadPool(20);

    public Future<Integer> makeDouble(Integer num){
        return executor.submit(()->{
           Thread.sleep(100);
           return num * num;
        });
    }
}
