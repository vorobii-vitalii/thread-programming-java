package com.thread.programming;

public class DaemonThreadDemo {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            System.out.println("Current thread : " + Thread.currentThread());
            while (true) {
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {}
                System.out.println("Woke up again");
            }
        });
//        thread.setDaemon(true);
        thread.start();
        Thread.sleep(2000);
        System.out.println("Bye bye");
    }

}
