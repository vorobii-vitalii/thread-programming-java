package com.thread.programming;

class CalcObject {
    private int a;

    CalcObject(int a) {
        this.a = a;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }
}

class Thread2 extends Thread {
    private final CalcObject calcObject;

    public Thread2(CalcObject calcObject) {
        this.calcObject = calcObject;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10000000; i++) {
            calcObject.setA(calcObject.getA() + 1);
        }
    }
}

public class SyncProblemDemo {

    public static void main(String[] args) throws InterruptedException {
        CalcObject calcObject = new CalcObject(0);
        Thread thread = new Thread2(calcObject);
        thread.start();
        for (int i = 0; i < 10000000; i++) {
            calcObject.setA(calcObject.getA() - 1);
        }
        thread.join();
        System.out.println("Result: " + calcObject.getA());
    }
}
