package com.thread.programming;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.DecimalFormat;

class SecondCounterLockUp extends JComponent implements Runnable {
    private volatile boolean keepRunning;
    private final Font paintFont;
    private volatile String timeMsg;
    private volatile int arcLen;

    public SecondCounterLockUp() {
        paintFont = new Font("SansSerif", Font.BOLD | Font.ITALIC, 14);
        timeMsg = "Never started";
        arcLen = 0;
        keepRunning = false;
    }

    public void runClock() {
        System.out.println("Thread running runClock() is " +
                Thread.currentThread().getName());
        DecimalFormat fmt = new DecimalFormat("0.000");
        long normalSleepTime = 100;
        int counter = 0;
        keepRunning = true;

        long startTime = System.currentTimeMillis();

        while (keepRunning) {
            try {
                Thread.sleep(normalSleepTime);
            } catch (InterruptedException e) {}
            counter++;
            double counterSecs = counter / 10.0;
            double elapsedTime = (System.currentTimeMillis() - startTime) / 1000;
            timeMsg = fmt.format(counterSecs) + " - " + fmt.format(elapsedTime);
            arcLen = ( (int) counterSecs % 60 ) * 360 / 60;
            repaint();
        }
    }

    public void stopClock() {
        keepRunning = false;
    }

    @Override
    public void paint(Graphics g) {
        System.out.println("Thread that invoked paint() - " +
                Thread.currentThread().getName());
        g.setColor(Color.BLACK);
        g.setFont(paintFont);
        g.drawString(timeMsg, 0, 15);
        g.fillOval(0, 20, 100, 100);
        g.setColor(Color.WHITE);
        g.fillOval(3, 23, 94, 94);
        g.setColor(Color.BLUE);
        g.fillArc(2, 22, 96, 96, 90, -arcLen);
    }

    @Override
    public void run() {
        runClock();
    }
}

public class SecondCounterLockupDemo extends JPanel {
    private final SecondCounterLockUp sc;
    private final JButton startB;
    private final JButton stopB;

    public SecondCounterLockupDemo() {
        sc = new SecondCounterLockUp();
        startB = new JButton("Start");
        stopB = new JButton("Stop");
        stopB.setEnabled(false);

        startB.addActionListener(e -> {
            startB.setEnabled(false);
            new Thread(sc).start();
            stopB.setEnabled(true);
            stopB.requestFocus();
        });

        stopB.addActionListener(e -> {
            stopB.setEnabled(false);
            sc.stopClock();
            startB.setEnabled(true);
            startB.requestFocus();
        });

        JPanel innerButtonP = new JPanel();
        innerButtonP.setLayout(new GridLayout(0,1, 0, 3));
        innerButtonP.add(startB);
        innerButtonP.add(stopB);

        JPanel buttonP = new JPanel();
        buttonP.setLayout(new BorderLayout());
        buttonP.add(innerButtonP, BorderLayout.NORTH);

        this.setLayout(new BorderLayout(10, 10));
        this.setBorder(new EmptyBorder(20, 20, 20, 20));
        this.add(buttonP, BorderLayout.WEST);
        this.add(sc, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        SecondCounterLockupDemo scm = new SecondCounterLockupDemo();
        JFrame f = new JFrame("Demo");
        f.setContentPane(scm);
        f.setSize(320, 200);
        f.setVisible(true);
        f.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

}
