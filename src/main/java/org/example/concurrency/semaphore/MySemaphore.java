package org.example.concurrency.semaphore;

public class MySemaphore {
    private int value;
    private final Object lock = new Object();

    public MySemaphore(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void myWait() throws InterruptedException {
        synchronized (lock) {
            while (value <= 0) {
                lock.wait();
            }
            value--;
        }
    }

    public void mySignal() {
        synchronized (lock) {
            value++;
            lock.notify();
        }
    }
}
