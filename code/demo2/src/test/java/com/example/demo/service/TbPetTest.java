package com.example.demo.service;

import com.example.demo.repository.model.TbPet;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TbPetTest {

    final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private TbPetService tbPetService;

    @Test
    public void testGetById(){

        TbPet pet = tbPetService.getById(1);
        log.info("-------get by id--------");
        System.out.println(pet);
        log.info("-------get by id--------");
    }

    @Test
    public void testUpdate(){

        TbPet pet = tbPetService.getById(1);
        pet.setMoney(100);
        boolean b = tbPetService.updateById(pet);
        Assert.assertTrue(b);
    }

    @Test
    public void testTransfer(){

        TbPet pet1 = tbPetService.getById(1);
        TbPet pet2 = tbPetService.getById(2);
        boolean b = tbPetService.moneyTransfer(10,pet1,pet2);
        Assert.assertTrue(b);
    }


}
