package com.example.demo.service;


import com.example.demo.repository.model.TbPet;
import com.example.demo.repository.model.TbUser;

import java.util.List;

public interface TbPetService {

    TbPet getById(Integer id);

    boolean updateById(TbPet pet);

    boolean moneyTransfer(int money, TbPet pet1, TbPet pet2);

    List<TbPet> getAll();
}