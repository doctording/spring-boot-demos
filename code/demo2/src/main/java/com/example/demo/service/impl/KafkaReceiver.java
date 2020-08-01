package com.example.demo.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;

/**
 * @Author mubi
 * @Date 2018/7/24 下午4:57
 */
//@Component
public class KafkaReceiver {

    final Logger log = LoggerFactory.getLogger(this.getClass());

    /**
     * 监听test主题,有消息就读取
     * @param message
     */
    @KafkaListener(topics = {"topic-test1"})
    public void consumer(String message) {
        log.info("test topic message : {}", message);
    }

}
