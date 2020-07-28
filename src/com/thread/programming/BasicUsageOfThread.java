package com.thread.programming;

class MyThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 200; i++) {
            System.out.println(i++);
        }
    }
}

public class BasicUsageOfThread {

    public static void main(String[] args) {
        Thread thread = new MyThread();
        thread.start();
        for (int i = 1; i < 200; i++) {
            System.out.println(i++);
        }
    }

}
