package com.example.demo.service.impl;

import com.example.demo.repository.mapper.TbPetMapper;
import com.example.demo.repository.model.TbPet;
import com.example.demo.repository.model.TbPetExample;
import com.example.demo.service.TbPetService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TbPetServiceImpl implements TbPetService {

    final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    TbPetMapper tbPetMapper;


    @Override
    public TbPet getById(Integer id) {
        return tbPetMapper.selectByPrimaryKey(id);
    }

    @Override
    public boolean updateById(TbPet pet) {
        TbPetExample tbPetExample = new TbPetExample();
        tbPetExample.createCriteria().andIdEqualTo(pet.getId());
        int count = tbPetMapper.updateByExampleSelective(pet, tbPetExample);
        return count == 0 ? false : true;
    }

    @Override
    public boolean moneyTransfer(int money, TbPet pet1, TbPet pet2) {
        pet1.setMoney(pet1.getMoney() - money);
        pet2.setMoney(pet2.getMoney() + money);
        boolean b = updateById(pet1);
        if (!b) {
            b = updateById(pet2);
            return false;
        }
        //
        return b;
    }

    @Override
    public List<TbPet> getAll() {
        return null;
    }


}