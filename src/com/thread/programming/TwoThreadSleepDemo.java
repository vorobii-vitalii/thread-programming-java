package com.thread.programming;

import javax.swing.*;

class TwoThreadSleep extends Thread {
    public void run() {
        loop();
    }

    private void loop() {
        Thread current = Thread.currentThread();
        String currentName = current.getName();
        System.out.println("just entered a loop() - " + currentName);
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(200L);
            } catch (InterruptedException ignored) {}
            System.out.println("name = " + currentName);
        }
        System.out.println("about to leave loop() - " + currentName);
    }
}

public class TwoThreadSleepDemo {

    public static void main(String[] args) {
        TwoThreadSleep tt = new TwoThreadSleep();
        tt.setName("my worker");
        tt.start();

        try {
            Thread.sleep(700);
        } catch (InterruptedException ignored) {}

        tt.run();
    }

}
