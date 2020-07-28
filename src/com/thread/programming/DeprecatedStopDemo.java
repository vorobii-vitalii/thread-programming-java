package com.thread.programming;

public class DeprecatedStopDemo implements Runnable {
    @Override
    public void run() {
        int count = 0;
        while (true) {
            System.out.println("Count: " + count++);
            try {
                Thread.sleep(300);
            } catch (InterruptedException ignored) {}
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new DeprecatedStopDemo());
        thread.start();
        Thread.sleep(2500);
        thread.stop();
    }

}
