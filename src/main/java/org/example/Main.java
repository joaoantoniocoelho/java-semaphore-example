package org.example;

import org.example.concurrency.semaphore.MySemaphore;
import org.example.concurrency.worker.MyWorker;

public class Main {
    public static void main(String[] args) {
        MySemaphore semaphore = new MySemaphore(2);

        startWorkers(semaphore);
    }

    public static void startWorkers(MySemaphore semaphore) {
        for(int i = 0; i < semaphore.getValue()+1; i++) {
            MyWorker worker = new MyWorker(semaphore, "Worker " + i);
            worker.start();
        }
    }
}