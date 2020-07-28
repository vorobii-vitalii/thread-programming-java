package com.thread.programming;

public class SetPriorityDemo {

    private static void printThreadInfo(Thread thread) {
        System.out.println(String.format("Thread %s has priority of %d", thread.getName(), thread.getPriority()));
    }

    public static void main(String[] args) {
        Runnable runnable = () -> printThreadInfo(Thread.currentThread());
        Thread thread = new Thread(runnable);
        thread.setPriority(8);
        thread.start();
        printThreadInfo(Thread.currentThread());
    }

}
