package com.thread.programming;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class VisualSuspendResumeDemo extends JComponent implements Runnable {
    private static final String[] symbolList = {"|", "/", "-", "\\", "|", "/", "-", "\\"};

    private Thread runThread;
    private JTextField symbolTF;

    public VisualSuspendResumeDemo() {
        symbolTF = new JTextField();
        symbolTF.setEditable(false);
        symbolTF.setFont(new Font("Monospaced", Font.BOLD | Font.ITALIC, 15));
        symbolTF.setHorizontalAlignment(JTextField.CENTER);

        final JButton suspendB = new JButton("Suspend");
        final JButton resumeB = new JButton("Resume");

        suspendB.addActionListener(e -> {
            System.out.println(Thread.currentThread());
            suspendNow();
        });
        resumeB.addActionListener(e -> {
            System.out.println(Thread.currentThread());
            resumeNow();
        });

        JPanel innerStackP = new JPanel();
        innerStackP.setLayout(new GridLayout(0, 1, 3, 3));
        innerStackP.add(symbolTF);
        innerStackP.add(suspendB);
        innerStackP.add(resumeB);

        this.setLayout(new FlowLayout(FlowLayout.CENTER));
        this.add(innerStackP);
    }

    private void resumeNow() {
        if (runThread != null) {
            runThread.resume();
        }
    }

    private void suspendNow() {
        if (runThread != null) {
            runThread.suspend();
        }
    }

    @Override
    public void run() {
        try {
            runThread = Thread.currentThread();
            int delay = 200;
            int count = 0;
            while (true) {
                symbolTF.setText(symbolList[count++ % symbolList.length]);
                Thread.sleep(delay);
            }
        }
        catch (InterruptedException e) {}
        finally {
            runThread = null;
        }
    }

    public static void main(String[] args) {
        VisualSuspendResumeDemo vsr = new VisualSuspendResumeDemo();
        Thread t = new Thread(vsr);
        t.start();

        JFrame f = new JFrame("Visual Suspend Resume");
        f.setContentPane(vsr);
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
