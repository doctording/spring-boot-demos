package com.example.demo.repo.repository.impl;

import com.example.demo.repo.mapper.TbUserMapper;
import com.example.demo.repo.model.TbUser;
import com.example.demo.repo.model.TbUserExample;
import com.example.demo.repo.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author mubi
 * @Date 2019/5/1 1:22 PM
 */
@Service
public class UserRepoImpl implements UserRepo {
    @Autowired
    TbUserMapper tbUserMapper;

    @Override
    public List<TbUser> getUserList() {
        List<TbUser> userList = tbUserMapper.selectByExample(new TbUserExample());
        return userList;
    }

}
