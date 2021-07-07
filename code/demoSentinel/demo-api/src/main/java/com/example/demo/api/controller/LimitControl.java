package com.example.demo.api.controller;

import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author mubi
 * @Date 2019/4/30 9:59 AM
 */
@RestController
@RequestMapping("/limit")
@Slf4j
public class LimitControl {

    Semaphore semaphore = new Semaphore(5,true);
    AtomicInteger counter = new AtomicInteger(0);

    /**
     * 该方法耗时100毫秒左右
     * 每次都使用信号量的 acquire，release
     * @return
     */
    public String req(){
        try{
            long start = System.currentTimeMillis();
            semaphore.acquire();
            TimeUnit.MILLISECONDS.sleep(100);
            counter.incrementAndGet();
            long cost = System.currentTimeMillis() - start;
            return "success:" + cost;
        }catch (Exception e){
            log.error("fail acquire", e);
            return "fail";
        }finally {
            semaphore.release();
        }
    }

    /**
     * tryAcquire 加超时参数，不至于立马返回失败，也不至于让调用者无限等待，
     * 而是将成功的请求控制在一个合理的响应时间，响应时间=超时时间+业务处理时间
     * @return
     */
    public String reqTry() {
        try{
            long start = System.currentTimeMillis();
            boolean ok = semaphore.tryAcquire(1, TimeUnit.SECONDS);
            TimeUnit.MILLISECONDS.sleep(100);
            counter.incrementAndGet();
            long cost = System.currentTimeMillis() - start;
            if(ok) {
                return "success:" + cost;
            }else{
                return "500: too many request";
            }
        }catch (Exception e){
            log.error("fail acquire", e);
            return "fail";
        }finally {
            semaphore.release();
        }
    }

    @ApiOperation("semaphore")
    @GetMapping(value = "/semaphore")
    public String limitTest() {
        return req();
    }

    @ApiOperation("semaphore")
    @GetMapping(value = "/semaphore/try")
    public String limitTryTest() {
        return reqTry();
    }

}
