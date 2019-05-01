package com.example.demo.repo;

import com.example.demo.repo.model.TbUser;
import com.example.demo.repo.repository.UserRepo;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@Slf4j
@EnableAutoConfiguration(exclude= {DataSourceAutoConfiguration.class})
public class DemoRepoApplicationTests {

	@Autowired
	UserRepo userRepo;

	@Test
	public void testGetAllUsers(){
		List<TbUser> userList = userRepo.getUserList();
		log.debug("===testGetAllUsers===");
		userList.forEach(tbUser -> {
			log.info("user:" + tbUser.toString());
		});
		log.debug("===testGetAllUsers===");
	}

}
