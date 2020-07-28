package com.thread.programming;

public class ThreadStartDemo {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                System.out.println(i);
            }
        });
        thread.start();
        System.out.println(thread.isAlive());
//        thread.start(); Throws IllegalThreadStateException
        thread.join();
        System.out.println(thread.isAlive());
    }

}
