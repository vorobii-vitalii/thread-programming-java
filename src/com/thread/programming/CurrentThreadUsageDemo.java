package com.thread.programming;

class Thread3 extends Thread {
    private Thread creator;

    public Thread3(String name) {
        super(name);
        creator = Thread.currentThread();
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            printMsg();
        }
    }

    public void printMsg() {
        Thread current = Thread.currentThread();
        System.out.println(current.getName());
    }

}


public class CurrentThreadUsageDemo {

    public static void main(String[] args) {
        Thread.currentThread().setName("Oracle thread");
        Thread3 thread3 = new Thread3("Thread3");
        thread3.start();
        for (int i = 0; i < 5; i++) {
            thread3.printMsg();
        }

        try {
            thread3.join();
        } catch (InterruptedException ignored) { }

        System.out.println("Finished");
    }

}
