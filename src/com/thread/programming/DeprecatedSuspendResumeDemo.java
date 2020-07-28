package com.thread.programming;

public class DeprecatedSuspendResumeDemo implements Runnable {
    private volatile int firstValue;
    private volatile int secondValue;

    public boolean areValuesEqual() {
        return firstValue == secondValue;
    }

    @Override
    public void run() {
        try {
            firstValue = 0;
            secondValue = 0;
            workMethod();
        }
        catch (InterruptedException e) {
            System.out.println("Interrupted while in workMethod()");
        }
    }

    private void workMethod() throws InterruptedException {
        int val = 1;
        while (true) {
            stepOne(val);
            stepTwo(val);
            val++;
            Thread.sleep(200);
        }
    }

    private void stepTwo(int val) throws InterruptedException {
        firstValue = val;
        Thread.sleep(300);
    }

    private void stepOne(int val) {
        secondValue = val;
    }

    public static void main(String[] args) throws InterruptedException {
        DeprecatedSuspendResumeDemo dsr = new DeprecatedSuspendResumeDemo();
        Thread thread = new Thread(dsr);
        thread.start();

        Thread.sleep(1000);

        for (int i = 0; i < 30; i++) {
            thread.suspend();
            System.out.println("dsr.areValuesEqual() = " + dsr.areValuesEqual() );
            thread.resume();
            Long timeOut = (long) (Math.random() * 2500.0);
            System.out.println(timeOut);
            Thread.sleep(timeOut);
        }

        System.exit(0);
    }
}
