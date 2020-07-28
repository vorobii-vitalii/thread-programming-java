package com.thread.programming;

class ThreadSleep extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.println(i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class ThreadSleep2Demo {

    public static void main(String[] args) {
        new ThreadSleep().start();
    }

}
