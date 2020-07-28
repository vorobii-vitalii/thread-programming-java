package com.thread.programming;

public class AlternateResumeSuspendDemo implements Runnable {
    private volatile int firstValue;
    private volatile int secondValue;
    private volatile boolean suspended;

    public boolean areValuesEqual() {
        return firstValue == secondValue;
    }

    public void setSuspended(boolean suspended) {
        this.suspended = suspended;
    }

    @Override
    public void run() {
        try {
            firstValue = 0;
            secondValue = 0;
            workMethod();
        }
        catch (InterruptedException e) {
            System.out.println("Thread has been interrupted");
        }
    }

    private void workMethod() throws InterruptedException {
        int val = 1;
        while (true) {
            if (!suspended) {
                stepOne(val);
                stepTwo(val);
                Thread.sleep(200);
            }
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
        AlternateResumeSuspendDemo dsr = new AlternateResumeSuspendDemo();
        Thread thread = new Thread(dsr);
        thread.start();

        Thread.sleep(1000);

        for (int i = 0; i < 30; i++) {
            dsr.setSuspended(true);
            System.out.println("dsr.areValuesEqual() = " + dsr.areValuesEqual() );
            dsr.setSuspended(false);
            Long timeOut = (long) (Math.random() * 2500.0);
            System.out.println(timeOut);
            Thread.sleep(timeOut);
        }

        System.exit(0);
    }
}
