package com.thread.programming;

public class ThreadSleepDemo {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Start");
        Thread.sleep(2000); // Puts Thread.currentThread() on suspend state
        System.out.println("End");
    }

}
