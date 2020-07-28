package com.thread.programming;

public class PiInterruptDemo implements Runnable {
    private double lastPiApproximation;

    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(new PiInterruptDemo());
        t.start();
        Thread.sleep(1000);
        t.interrupt();
    }

    @Override
    public void run() {
        try {
            System.out.println("Goal: " + Math.PI);
            calcPi(1e-10);
            System.out.println("PI according to precision:" + lastPiApproximation);
        }
        catch (InterruptedException e) {
            System.out.println("Calculation was interrupted: last value - " + lastPiApproximation);
        }
    }

    private void calcPi(double precision) throws InterruptedException {
        lastPiApproximation = 0.0;
        long iteration = 0;
        int sign = -1;
        while (Math.abs(lastPiApproximation - Math.PI) > precision) {
            if (Thread.interrupted()) {
                throw new InterruptedException();
            }
            iteration++;
            sign = -sign;
            lastPiApproximation += sign * 4.0 / ( (2 * iteration) - 1 );
        }
    }

}
