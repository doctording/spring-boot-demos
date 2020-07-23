package com.example.demo.processor;


import com.example.demo.component.BloomFilterHelper;
import com.example.demo.component.RedisService;
import com.example.demo.repository.model.TbUser;
import com.example.demo.service.TbUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RedisRunner implements CommandLineRunner {

    @Autowired
    private RedisService redisService;

    @Autowired
    private TbUserService tbUserService;

    @Autowired
    private BloomFilterHelper bloomFilterHelper;

    @Override
    public void run(String... args) throws Exception {
        List<TbUser> tbUsers = tbUserService.getAllUser();
        // 初始化布隆过滤器内容
        for (TbUser user : tbUsers) {
            String value = String.valueOf(user.getId());
            redisService.addByBloomFilter(bloomFilterHelper, "bloom", value);
        }
    }

}
