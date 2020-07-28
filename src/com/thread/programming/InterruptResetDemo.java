package com.thread.programming;

public class InterruptResetDemo {

    /**
     * Checks the status of thread without altering
     * @see Thread
     */
    private static void printStatus(Thread t) {
        System.out.println(String.format("Thread is interrupted? %b", t.isInterrupted()));
    }

    public static void main(String[] args) {
        Thread currentThread = Thread.currentThread();
        printStatus(currentThread);
        currentThread.interrupt();
        printStatus(currentThread);
        System.out.println("Another method :  " + Thread.interrupted());
        printStatus(currentThread);
    }

}
