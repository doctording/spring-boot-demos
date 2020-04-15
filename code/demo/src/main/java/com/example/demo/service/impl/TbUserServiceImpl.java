package com.example.demo.service.impl;

import com.example.demo.repository.mapper.TbUserMapper;
import com.example.demo.repository.model.TbUser;
import com.example.demo.repository.model.TbUserExample;
import com.example.demo.service.TbUserService;
import com.example.demo.utils.RedisStringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TbUserServiceImpl implements TbUserService{

    @Autowired
    TbUserMapper tbUserMapper;

    @Override
    public String fortest(){
        return "For Test";
    }

    @Override
    public List<TbUser> getAllUser() {
        List<TbUser> userList = tbUserMapper.selectByExample(new TbUserExample());
        return userList;
    }

    @Override
    public TbUser getById(Integer id) {
        System.out.println("get by id:" + id + " " + System.currentTimeMillis());
        return tbUserMapper.selectByPrimaryKey(id);
    }

    @Override
    public String getNameById(Integer id) {
        TbUser tbUser =  tbUserMapper.selectByPrimaryKey(id);
        if(tbUser != null){
            return tbUser.getName();
        }
        return null;
    }

    @Override
    public String getNameCacheById(Integer id) {
        String key = String.valueOf(id);
        if(RedisStringUtil.existRedisKey(key)){
            // 访问缓存
            System.out.println("get from redis " + System.currentTimeMillis());
            return RedisStringUtil.getRedisKey(key);
        }else {
            // 访问数据库
            String name = getNameById(id);
            if(name == null){
                // 数据库中没有
                return "无";
            }else {
                // 数据库中有,设置缓存
                int sec = 60;
                RedisStringUtil.setRedisKey(key, name, sec);
                return name;
            }
        }
    }
}
