package com.example.demorepo;

import com.example.demorepo.repository.mapper.TbUserMapper;
import com.example.demorepo.repository.model.TbUser;
import com.example.demorepo.repository.model.TbUserExample;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class DemoRepoApplicationTests {

	@Autowired
	private TbUserMapper tbUserMapper;

	@Test
	public void testGetAllUsers(){
		List<TbUser> userList = tbUserMapper.selectByExample(new TbUserExample());
		System.out.println("==========");
		userList.forEach(tbUser -> {
			System.out.println(tbUser);
		});
		System.out.println("==========");
	}

}
