package com.example.demo.api.syncrecord;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * @Author mubi
 * @Date 2019/7/10 3:21 PM
 *
 * LinkedBlockingQueue
 */
public class RecordContainer {
    private LinkedBlockingQueue<Record> queue = new LinkedBlockingQueue(128);
    private final int RETRY = 3;

    private RecordContainer() {
    }

    public Record poll() throws InterruptedException {
        return queue.take();
    }

    public boolean push(Record record) {
        for (int i = 0; i < RETRY; i++) {
            if (queue.offer(record)) {
                return true;
            }
        }
        return false;
    }

    public static RecordContainer getInstance() {
        return Builder.INSTANCE;
    }

    private static class Builder {
        public static final RecordContainer INSTANCE = new RecordContainer();
    }

}
