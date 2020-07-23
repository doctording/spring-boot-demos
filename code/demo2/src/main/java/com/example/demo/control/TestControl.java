package com.example.demo.control;

import com.example.demo.repository.model.TbUser;
import com.example.demo.service.TbUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @Author mubi
 * @Date 2018/7/20 下午3:07
 */
@RestController
public class TestControl {

    @Autowired
    TbUserService tbUserService;

    final Logger log = LoggerFactory.getLogger(this.getClass());


    @GetMapping(value = "/test")
    public String getTest() {
        return "hello test";
    }

    @GetMapping(value = "/test-cost")
    public String getTestCost() {
        log.info("start");
        long t1 = System.currentTimeMillis();
        try{
            TimeUnit.SECONDS.sleep(20);
        }catch (Exception e){
            log.error("getTestCost error", e);
        }
        long t2 = System.currentTimeMillis();
        log.info("end");
        return "hello test:" + t1 + "-" + t2;
    }

    @GetMapping(value = "/test-service")
    public String getTestService() {
        return tbUserService.fortest();
    }

    @GetMapping(value = "/test-all")
    public List<TbUser> getTestAllUser() {
        return tbUserService.getAllUser();
    }
}
