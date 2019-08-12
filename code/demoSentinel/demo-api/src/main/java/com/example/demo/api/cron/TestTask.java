package com.example.demo.api.cron;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * @Author mubi
 * @Date 2019/7/3 8:27 PM
 */
@Slf4j
@Component
public class TestTask {
    static SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss,SSS");

//    @Scheduled(cron ="*/3 * * * * ?")
    public void scheduled() {
        int number = 0;
        try{
            int END = 6;
            int START = 4;
            //创建Random类对象
            Random random = new Random();
            //产生随机数
            number = random.nextInt(END - START + 1) + START;

            log.info(String.format("scheduled at: %s %d", df.format(new Date()), number));
            TimeUnit.SECONDS.sleep(number);
        }catch (Exception e){

        }
    }
}
