package com.example.demo.control;

import org.redisson.Redisson;
import org.redisson.api.RLock;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * redis： https://redis.io/， https://try.redis.io/
 *
 * setnx key val （set if not exist x）
 *  当key不存在，设置key,val
 *  当key存在，不做任何操作
 */
@RestController
public class StockControl {

    private static final Logger log = LoggerFactory.getLogger(StockControl.class);

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    private String stockReduce(){
        int stock = Integer.parseInt(stringRedisTemplate.opsForValue().get("stock"));
        if (stock > 0) {
            int realStock = stock - 1;
            try {
                Random r = new Random();
                TimeUnit.MILLISECONDS.sleep(r.nextInt(100));
            } catch (Exception e) {

            }
            stringRedisTemplate.opsForValue().set("stock", String.valueOf(realStock));
            log.info("stock: {} sub success to {}", stock, realStock);
        } else {
            log.info("stock sub failed for stock == 0");
        }

        return "success";
    }

    @PostMapping(value = "/deduct_stock")
    public String deductStock() {
        return stockReduce();
    }

    @PostMapping(value = "/deduct_stock_sync")
    public String deductStockSync() {
        synchronized (this) {
            return stockReduce();
        }
    }

    @PostMapping(value = "/deduct_stock_lock")
    public String deductStockLock() throws Exception {
        // setnx，redis单线程
        String lockKey = "lockKey";
        String clientId = UUID.randomUUID().toString();
        // 如下两句要原子操作
//        Boolean setOk = stringRedisTemplate.opsForValue().setIfAbsent(lockKey, lockVal);
//        stringRedisTemplate.expire(lockKey, 10 , TimeUnit.SECONDS); // 设置过期时间
        Boolean setOk = stringRedisTemplate.opsForValue().setIfAbsent(lockKey, clientId, 10, TimeUnit.SECONDS);
        if (!setOk) {
            throw new Exception("业务繁忙，请稍后再试");
        }

        String retVal;
        try {
            // 只有一个线程能执行成功,可能有业务异常抛出来，可能宕机等等；但无论如何要释放锁
            retVal = stockReduce();
        } finally {
            // 可能失败
            if (clientId.equals(stringRedisTemplate.opsForValue().get(lockKey))) {
                stringRedisTemplate.delete(lockKey);
            }
        }
        return retVal;
    }

    @Autowired
    private Redisson redisson;

    @PostMapping(value = "/deduct_stock_redisson")
    public String deductStockRedisson() throws Exception {
        String lockKey = "lockKey";
        RLock rLock = redisson.getLock(lockKey);
        String retVal;
        try {
            rLock.lock();
            // 只有一个线程能执行成功,可能有业务异常抛出来，可能宕机等等；但无论如何要释放锁
            retVal = stockReduce();
        } finally {
            rLock.unlock();
        }
        return retVal;
    }

}
