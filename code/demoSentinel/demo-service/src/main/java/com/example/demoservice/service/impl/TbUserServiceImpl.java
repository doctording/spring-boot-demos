package com.example.demoservice.service.impl;

import com.example.demo.repo.mapper.TbUserMapper;
import com.example.demo.repo.model.TbUser;
import com.example.demo.repo.model.TbUserExample;
import com.example.demo.repo.repository.UserRepo;
import com.example.demoservice.service.TbUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author mubi
 * @Date 2019/4/30 9:52 AM
 */
@Service
@Slf4j
public class TbUserServiceImpl implements TbUserService {

    @Autowired
    UserRepo userRepo;

    @Override
    public String forTest(){
        return "For Test";
    }

    @Override
    public List<TbUser> getAllUsers() {
       List<TbUser> userList = userRepo.getUserList();
       return userList;
    }
}
