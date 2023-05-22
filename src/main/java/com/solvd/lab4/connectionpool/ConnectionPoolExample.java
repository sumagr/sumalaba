package com.solvd.lab4.connectionpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ConnectionPoolExample {
    public static void main(String[] args) {
        ConnectionPool connectionPool = new ConnectionPool(5);

        ExecutorService executorService = Executors.newFixedThreadPool(7);

        for (int i = 0; i < 5; i++) {
            executorService.submit(new AcquireConnectionTask(connectionPool));
        }

        for (int i = 0; i < 2; i++) {
            executorService.submit(new WaitForConnectionTask(connectionPool));
        }

        executorService.shutdown();
        try {
            executorService.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("All tasks completed.");
    }
}

