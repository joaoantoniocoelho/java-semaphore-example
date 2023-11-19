package org.example.concurrency.worker;

import org.example.concurrency.semaphore.MySemaphore;

public class MyWorker extends Thread {
    private MySemaphore semaphore;

    public MyWorker(MySemaphore semaphore, String name) {
        super(name);
        this.semaphore = semaphore;
    }

    public void run() {
        try {
            System.out.printf("%s is waiting for a permit.%n", getName());
            semaphore.myWait();
            System.out.printf("%s has acquired a permit.%n", getName());
            Thread.sleep(1000);

        } catch (InterruptedException e) {
            System.out.printf("%s was interrupted.%n", getName());
        } finally {
            System.out.printf("%s has released a permit.%n", getName());
            semaphore.mySignal();
        }
    }
}
