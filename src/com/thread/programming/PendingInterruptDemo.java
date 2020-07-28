package com.thread.programming;

public class PendingInterruptDemo {
    private static boolean shouldInterrupt = false;

    public static void main(String[] args) {
        if (shouldInterrupt) {
            Thread.currentThread().interrupt();
        }
        long startTime = System.currentTimeMillis();
        System.out.println("About to sleep");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(String.format("Time elapsed: %s", System.currentTimeMillis() - startTime));
    }

}
