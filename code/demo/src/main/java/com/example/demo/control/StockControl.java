package com.example.demo.control;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * redis： https://redis.io/， https://try.redis.io/
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
                TimeUnit.MILLISECONDS.sleep(50);
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

}
