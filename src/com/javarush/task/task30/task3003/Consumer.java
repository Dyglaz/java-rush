package com.javarush.task.task30.task3003;

import java.util.concurrent.TransferQueue;

public class Consumer implements Runnable {
    private final TransferQueue<ShareItem> queue;

    public Consumer(TransferQueue<ShareItem> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(450);
            while(true){
                ShareItem shareItem = queue.take();
                System.out.format("Processing %d\n", shareItem.toString());
            }
        } catch (InterruptedException e) {
        }
    }
}
