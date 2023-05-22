package com.solvd.lab4.thread;

public class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("Thread using Runnable: " + Thread.currentThread().getId() + " is running.");

        for (int i = 0; i < 5; i++) {
            System.out.println("Task " + i + " in Thread " + Thread.currentThread().getId());
        }
    }
}
