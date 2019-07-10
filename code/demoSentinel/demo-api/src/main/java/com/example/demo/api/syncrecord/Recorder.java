package com.example.demo.api.syncrecord;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.concurrent.*;

/**
 * @Author mubi
 * @Date 2019/7/10 3:21 PM
 */
@Slf4j
@Component
public class Recorder {

    private static RecordContainer queue = RecordContainer.getInstance();

    public boolean record(Record record) {
        try {
            if (!queue.push(record)) {
                log.error("error when push record query {}", record.toString());
            }
        } catch (Exception e) {
            log.error("error when push record query", e);
        }
        return true;
    }

    @PostConstruct
    void saveRecord() {
        new Thread(new Manager()).start();
    }

    private class Manager implements Runnable {

        @Override
        public void run() {
            ThreadFactory namedThreadFactory = new ThreadFactoryBuilder().setNameFormat("record-pool-%d").build();
            ExecutorService executor = new ThreadPoolExecutor(1, 3, 0L,
                    TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>(128),
                    namedThreadFactory, new ThreadPoolExecutor.AbortPolicy());

            while (true) {
                Record record = null;
                try {
                    record = queue.poll();
                } catch (InterruptedException e) {
                    log.error("Interrupted error while record", e);
                    try {
                        Thread.sleep(30);
                    } catch (InterruptedException e1) {
                        e1.printStackTrace();
                    }
                }
                if (record != null) {
                    executor.execute(new RecordSaver(record));
                }
            }
        }
    }

    private class RecordSaver implements Runnable {
        Record record;

        RecordSaver(Record record) {
            this.record = record;
        }

        @Override
        public void run() {
            try {
                try {
                    Thread.sleep(30);
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
                log.info("record save");
            } catch (Throwable e) {
                log.error("error while record", e);
            }
        }
    }
}
