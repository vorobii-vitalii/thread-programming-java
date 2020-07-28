package com.thread.programming;

public class AlternateStopDemo implements Runnable {
    private boolean shouldStop;

    public void kill() {
        shouldStop = true;
    }

    @Override
    public void run() {
        int count = 0;
        while (!shouldStop) {
            System.out.println("Count: " + count++);
            try {
                Thread.sleep(200);
            } catch (InterruptedException ignored) {}
        }
    }

    public static void main(String[] args) throws InterruptedException {
        AlternateStopDemo asd = new AlternateStopDemo();
        Thread t = new Thread(asd);
        t.start();
        Thread.sleep(2000);
        asd.kill();
    }

}
