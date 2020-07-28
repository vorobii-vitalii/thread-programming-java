package com.thread.programming;

public class InterruptCheckDemo {

    private static void printThreadInterruptStatus(Thread thread) {
        System.out.println(String.format("Thread is interrupted ? - %b ", thread.isInterrupted()));
    }

    public static void main(String[] args) {
        Thread currentThread = Thread.currentThread();
        printThreadInterruptStatus(currentThread);
        currentThread.interrupt();
        printThreadInterruptStatus(currentThread);
        try {
            Thread.sleep(2000);
            System.out.println("Wasnt interrupted");
        }
        catch (InterruptedException e) {
            System.out.println("Has been interrupted");
        }
        printThreadInterruptStatus(currentThread);
    }

}
