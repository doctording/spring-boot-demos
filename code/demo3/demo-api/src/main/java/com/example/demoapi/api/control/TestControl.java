package com.example.demoapi.api.control;

import com.example.demorepo.repository.model.TbUser;
import com.example.demoservice.service.TbUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestControl {

    @Autowired
    TbUserService tbUserService;

    @GetMapping(value = "/test")
    public String getTest() throws Exception {
        return "hello test";
    }

    @GetMapping(value = "/test-service")
    public String getTestService() throws Exception {
        return tbUserService.fortest();
    }

    @GetMapping(value = "/test-all")
    public List<TbUser> getTestAll() throws Exception {
        return tbUserService.getAllUsers();
    }
}
