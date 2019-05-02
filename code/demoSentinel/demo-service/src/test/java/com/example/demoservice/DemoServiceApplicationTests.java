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

	/**
	 * QPS限流测试
	 * qps限流为20
	 * 测试qps=60, 基本上是前20返回`HelloWorld`, 后面40返回`Blocked`
	 */
	@Test
	public void testForTest(){
		for(int i=0;i<60;i++) {
			String limitTest = tbUserService.forTest();
			log.info(String.format("%d---------limit:%s",i,limitTest));
		}
	}

	@Test
	public void testGetAllUsers(){
		List<TbUser> userList = tbUserService.getAllUsers();
		userList.forEach(tbUser -> {
			log.info("user:" + tbUser);
		});
	}
}
