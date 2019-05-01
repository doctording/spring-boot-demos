package com.example.demo.repo.repository;

import com.example.demo.repo.model.TbUser;

import java.util.List;

public interface UserRepo {
    List<TbUser> getUserList();
}
