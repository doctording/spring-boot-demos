package com.example.demoservice;

import com.example.demorepo.repository.model.TbUser;
import com.example.demoservice.service.TbUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
//@ContextConfiguration(classes = {DemoServiceApplication.class})
public class DemoServiceApplicationTests {

	@Autowired
	TbUserService tbUserService;

	@Test
	public void testFortest(){
		System.out.println("===testFortest==========");
		System.out.println(tbUserService.fortest());
		System.out.println("===testFortest==========");
	}

	@Test
	public void testGetAllUsers(){
		System.out.println("===testGetAllUsers==========");
		List<TbUser> userList = tbUserService.getAllUsers();
		userList.forEach(tbUser -> {
			System.out.println(tbUser);
		});
		System.out.println("===testGetAllUsers==========");
	}
}
