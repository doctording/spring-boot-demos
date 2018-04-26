package com.example.demo.service;

import com.example.demo.repository.model.TbUser;
import com.example.demo.service.TbUserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TbUserTest {

    final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private TbUserService tbUserService;

    @Test
    public void testGetAllUsers(){

        List<TbUser> userList = tbUserService.getAllUser();
        log.info("-------getAllUser--------");
        userList.forEach(tbUser -> {
            //System.out.println(tbUser);
            log.info(tbUser.toString());
        });
        log.info("-------getAllUser--------");
    }
}
