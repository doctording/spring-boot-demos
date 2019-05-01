package com.example.demoservice;

import com.example.demo.repo.model.TbUser;
import com.example.demoservice.service.TbUserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@Slf4j
public class DemoServiceApplicationTests {

	@Autowired
	TbUserService tbUserService;

	@Test
	public void testForTest(){
		log.debug("===testForTest==========");
		log.debug(tbUserService.forTest());
		log.debug("===testForTest==========");
	}

	@Test
	public void testGetAllUsers(){
		List<TbUser> userList = tbUserService.getAllUsers();
		userList.forEach(tbUser -> {
			log.info("user:" + tbUser);
		});
	}
}
