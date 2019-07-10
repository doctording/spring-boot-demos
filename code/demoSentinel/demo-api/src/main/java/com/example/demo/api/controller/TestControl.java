package com.example.demo.api.controller;

import com.example.demo.api.annotation.AfterLogger;
import com.example.demo.api.annotation.HttpLogger;
import com.example.demo.api.annotation.RecordLogger;
import com.example.demo.repo.model.TbUser;
import com.example.demoservice.service.TbUserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @Author mubi
 * @Date 2019/4/30 9:59 AM
 */
@RestController
@RequestMapping("/test")
public class TestControl {

    @Autowired
    TbUserService tbUserService;

    @HttpLogger
    @ApiOperation("测试接口")
    @GetMapping(value = "/alive")
    public String getTest(String str) {
        return "just test alive:" + str;
    }

    @ApiOperation("测试forTest接口")
    @GetMapping(value = "/service")
    public String getTestService() {
        return tbUserService.forTest();
    }

    @AfterLogger
    @ApiOperation("测试获取所有用户信息")
    @GetMapping(value = "/user/all")
    public List<TbUser> getTestAll() {
        return tbUserService.getAllUsers();
    }

    @RecordLogger
    @ApiOperation("testRecord")
    @GetMapping(value = "/record")
    public String testRecord() {
        try{
            TimeUnit.SECONDS.sleep(2);
        }catch (Exception e){
            e.printStackTrace();
        }
        return "sleep2sec";
    }
}
