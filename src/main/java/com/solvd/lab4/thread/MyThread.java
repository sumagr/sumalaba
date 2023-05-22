package com.solvd.lab4.thread;

public class MyThread extends Thread{
    @Override
    public void run() {
        System.out.println("Thread using Thread class: " + this.getId() + " is running.");

        for (int i = 0; i < 5; i++) {
            System.out.println("Task " + i + " in Thread " + this.getId());
        }
    }
}
