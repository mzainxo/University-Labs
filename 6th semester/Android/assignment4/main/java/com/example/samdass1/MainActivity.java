package com.example.samdass1;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView textViewStatus;
    private TextView textViewLog;
    private Button buttonStart;
    private Button buttonBlock;
    private Button buttonWait;
    private Button buttonTimedWait;
    private Button buttonInterrupt;
    private ScrollView scrollView;
    private Button buttonNotify;
    private Thread backgroundThread;
    private final Object lock = new Object();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewStatus = findViewById(R.id.textView_status);
        textViewLog = findViewById(R.id.textView_log);
        buttonStart = findViewById(R.id.button_start);
        scrollView = findViewById(R.id.scrollView_log);
        buttonBlock = findViewById(R.id.button_block);
        buttonWait = findViewById(R.id.button_wait);
        buttonTimedWait = findViewById(R.id.button_timed_wait);
        buttonInterrupt = findViewById(R.id.button_interrupt);
        buttonNotify = findViewById(R.id.button_notify);

        buttonStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startThread();
            }
        });

        buttonBlock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                blockThread();
            }
        });

        buttonWait.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                waitThread();
            }
        });

        buttonTimedWait.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timedWaitThread();
            }
        });

        buttonInterrupt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                interruptThread();
            }
        });

        buttonNotify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                notifyThread();
            }
        });
    }

    private void startThread() {
        buttonStart.setEnabled(false);
        buttonBlock.setVisibility(View.VISIBLE);
        buttonWait.setVisibility(View.VISIBLE);
        buttonTimedWait.setVisibility(View.VISIBLE);
        buttonInterrupt.setVisibility(View.VISIBLE);
        buttonNotify.setVisibility(View.VISIBLE);
        scrollView.setVisibility(View.VISIBLE);


        backgroundThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    updateStatus("RUNNABLE");
                    logMessage("Thread: STARTED");
                    logMessage("Thread: RUNNABLE");

                    synchronized (lock) {
                        while (!Thread.currentThread().isInterrupted()) {
                            lock.wait();
                        }
                    }
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();  // Preserve the interrupt status
                    updateStatus("INTERRUPTED");
                    logMessage("Thread: INTERRUPTED. \nClick 'Notify thread' to make it RUNNABLE again.");
                }
            }
        });

        updateStatus("NEW");
        logMessage("NEW THREAD CREATED");
        backgroundThread.start();
    }

    private void blockThread() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock) {
                    updateStatus("BLOCKED");
                    logMessage("Thread: BLOCKED");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();  // Preserve the interrupt status
                        updateStatus("INTERRUPTED");
                        logMessage("Thread: INTERRUPTED WHILE BLOCKED.");
                    }
                }
            }
        }).start();
    }

    private void waitThread() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock) {
                    try {
                        updateStatus("WAITING");
                        logMessage("Thread: WAITING");
                        lock.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();  // Preserve the interrupt status
                        updateStatus("INTERRUPTED");
                        logMessage("Thread: INTERRUPTED WHILE WAITING");
                    }
                }
            }
        }).start();
    }

    private void timedWaitThread() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock) {
                    try {
                        updateStatus("TIMED_WAITING");
                        logMessage("Thread: TIMED_WAITING");
                        lock.wait(2000);
                        if (!Thread.currentThread().isInterrupted()) {
                            updateStatus("RUNNABLE");
                            logMessage("Thread: RUNNABLE AGAIN AFTER TIMED_WAITING");
                        }
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();  // Preserve the interrupt status
                        updateStatus("INTERRUPTED");
                        logMessage("Thread: INTERRUPTED WHILE TIMED_WAITING");
                    }
                }
            }
        }).start();
    }

    private void interruptThread() {
        if (backgroundThread != null && backgroundThread.isAlive()) {
            backgroundThread.interrupt();
            //logMessage("Thread: INTERRUPTED");
        }
    }

    private void notifyThread() {
        synchronized (lock) {
            lock.notify();
            updateStatus("RUNNABLE");
            logMessage("Thread: RUNNABLE AFTER NOTIFY");
        }
    }

    private void updateStatus(final String status) {
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            @Override
            public void run() {
                textViewStatus.setText("Thread Status: " + status);
            }
        });
    }

    private void logMessage(final String message) {
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            @Override
            public void run() {
                textViewLog.append(message + "\n");
                ScrollView scrollView = findViewById(R.id.scrollView_log);
                scrollView.post(new Runnable() {
                    @Override
                    public void run() {
                        scrollView.fullScroll(View.FOCUS_DOWN);
                    }
                });
            }
        });
    }
}
