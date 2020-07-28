package com.thread.programming;

class ThreadToInterrupt implements Runnable {
    private static final Long time = 5000L;

    @Override
    public void run() {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
            return;
        }
        System.out.println("It wont be printed");
    }
}

public class InterruptExampleDemo {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new ThreadToInterrupt());
        thread.start();
        Thread.sleep(1000);
        thread.interrupt();
        System.out.println("It will be printed");
    }

}
