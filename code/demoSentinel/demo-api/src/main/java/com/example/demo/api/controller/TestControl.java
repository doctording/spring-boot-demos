package com.example.demo.api.controller;

import com.example.demo.repo.model.TbUser;
import com.example.demoservice.service.TbUserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author mubi
 * @Date 2019/4/30 9:59 AM
 */
@RestController
@RequestMapping("/test")
public class TestControl {

    @Autowired
    TbUserService tbUserService;

    @ApiOperation("测试接口")
    @GetMapping(value = "/alive")
    public String getTest() {
        return "just test alive";
    }

    @ApiOperation("测试forTest接口")
    @GetMapping(value = "/service")
    public String getTestService() {
        return tbUserService.forTest();
    }

    @ApiOperation("测试获取所有用户信息")
    @GetMapping(value = "/user/all")
    public List<TbUser> getTestAll() {
        return tbUserService.getAllUsers();
    }

}
