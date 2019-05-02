package com.example.demoservice.service.impl;

import com.alibaba.csp.sentinel.Entry;
import com.alibaba.csp.sentinel.SphU;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.example.demo.repo.mapper.TbUserMapper;
import com.example.demo.repo.model.TbUser;
import com.example.demo.repo.model.TbUserExample;
import com.example.demo.repo.repository.UserRepo;
import com.example.demoservice.limit.QueryLimit;
import com.example.demoservice.service.TbUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author mubi
 * @Date 2019/4/30 9:52 AM
 */
@Service
@Slf4j
public class TbUserServiceImpl implements TbUserService {

    @Autowired
    UserRepo userRepo;

    @Override
    public String forTest(){
        QueryLimit.initFlowRules();
        // 1.5.0 版本开始可以直接利用 try-with-resources 特性
        try (Entry entry = SphU.entry("HelloWorld")) {
            // 被保护的逻辑
            return "HelloWorld";
        } catch (BlockException ex) {
            // 处理被流控的逻辑
            return "Blocked";
        }
    }

    @Override
    public List<TbUser> getAllUsers() {
       List<TbUser> userList = userRepo.getUserList();
       return userList;
    }
}
