package com.thread.programming;

public class BusyPauseDemo {

    private static long getTimeAfterNSeconds(int seconds) {
        long currentTime = System.currentTimeMillis();
        return currentTime + (seconds * 1000);
    }

    public static void main(String[] args) {
        long end = getTimeAfterNSeconds(2);
        pauseTill(end);
        System.out.println("End");
    }

    private static void pauseTill(long end) {
        while (System.currentTimeMillis() < end) {}
    }

}
