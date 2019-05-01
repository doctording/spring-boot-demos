package com.example.demoservice.service;


import com.example.demo.repo.model.TbUser;

import java.util.List;

public interface TbUserService {
    String forTest();

    List<TbUser> getAllUsers();
}