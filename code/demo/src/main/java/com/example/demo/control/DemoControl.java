package com.example.demo.control;

import com.demo.starter.service.DemoService;
import com.example.demo.repository.model.TbUser;
import com.example.demo.service.TbUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class DemoControl {

    @Resource(name = "demo")
    private DemoService demoService;

    /**
     * 访问：http://localhost:8080/say
      */
    @GetMapping("/say")
    public String sayWhat() {
        return demoService.say();
    }

}
