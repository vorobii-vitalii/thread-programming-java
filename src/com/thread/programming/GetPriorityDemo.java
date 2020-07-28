package com.thread.programming;

public class GetPriorityDemo {

    public static void main(String[] args) {
        Thread currentThread = Thread.currentThread();
        System.out.println(String.format("Current priority of thread %s - %d", currentThread.getName(), currentThread.getPriority()));
    }

}
