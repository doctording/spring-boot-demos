package com.example.demoservice;

import com.example.demoservice.rate.RateService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.Time;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @Author mubi
 * @Date 2019/8/10 11:38
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@Slf4j
public class RateLimitTest {

    @Autowired
    RateService rateService;

    /**
     * 瞬时流量很高, 基本上只有开始的几个可以运行，后面大部分请求被限流了，因为计数器增加了，还来不及减少
     */
    @Test
    public void testCountRate() throws Exception{
        ExecutorService pool = Executors.newFixedThreadPool(10);
        for(int i=0;i<15;i++) {
            pool.execute(() -> {
                String ans = rateService.countRateLimiter();
                log.info("ans:" + ans);
            });
        }
        TimeUnit.SECONDS.sleep(10);
    }

    /**
     * 正常被限流
     * @throws Exception
     */
    @Test
    public void testCountRate2() throws Exception{
        ExecutorService pool = Executors.newFixedThreadPool(10);
        for(int i=0;i<6;i++) {
            pool.execute(() -> {
                String ans = rateService.countRateLimiter();
                log.info("ans:" + ans);
            });
            TimeUnit.MILLISECONDS.sleep(200);
        }
        TimeUnit.SECONDS.sleep(1);
        pool.execute(() -> {
            String ans = rateService.countRateLimiter();
            log.info("ans:" + ans);
        });
    }


    /**
     * 瞬时流量很高,可以使请求在阻塞队列中排队，而不是马上拒绝请求，从而达到一个流量削峰的目的
     */
    @Test
    public void testCountRateSemaphore() throws Exception{
        ExecutorService pool = Executors.newFixedThreadPool(10);
        for(int i=0;i<15;i++) {
            pool.execute(() -> {
                String ans = rateService.countRateLimiterSemaphore();
                log.info("ans:" + ans);
            });
        }
        TimeUnit.SECONDS.sleep(10);
    }

    /**
     */
    @Test
    public void testCountRateGuava() throws Exception{
        ExecutorService pool = Executors.newFixedThreadPool(10);
        for(int i=0;i<10;i++) {
            pool.execute(() -> {
                String ans = rateService.countRateLimiterGuaua();
                log.info("ans:" + ans);
            });
            TimeUnit.MILLISECONDS.sleep(100);
        }
        TimeUnit.SECONDS.sleep(10);
    }

}
