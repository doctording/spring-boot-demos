package com.example.demo.service;

import com.example.demo.component.BloomFilterHelper;
import com.example.demo.component.RedisService;
import com.example.demo.repository.model.TbUser;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class BloomFilterTest {

    @Autowired
    private RedisService redisService;

    @Autowired
    private BloomFilterHelper bloomFilterHelper;

    @Autowired
    private TbUserService tbUserService;

    @Test
    public void testSet(){
        List<TbUser> tbUsers = tbUserService.getAllUser();
        // 初始化布隆过滤器内容
        for (TbUser user : tbUsers) {
            String value = String.valueOf(user.getId());
            redisService.addByBloomFilter(bloomFilterHelper, "bloom", value);
        }
        String value1 = "1";
        Boolean b = redisService.includeByBloomFilter(bloomFilterHelper, "bloom", value1);
        Assert.assertTrue(b);
        String value2 = "100";
        Boolean b2 = redisService.includeByBloomFilter(bloomFilterHelper, "bloom", value2);
        Assert.assertTrue( ! b2);
    }

}
