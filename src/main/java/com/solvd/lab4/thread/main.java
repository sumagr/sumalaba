package com.solvd.lab4.thread;

public class main {
    public static void main(String[] args) {
        Thread thread1 = new Thread(new MyRunnable());
        Thread thread2 = new Thread(new MyRunnable());

        thread1.start();
        thread2.start();

        MyThread thread3 = new MyThread();
        MyThread thread4 = new MyThread();

        thread3.start();
        thread4.start();
    }
}
