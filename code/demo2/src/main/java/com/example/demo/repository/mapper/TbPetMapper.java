package com.example.demo.repository.mapper;

import com.example.demo.repository.model.TbPet;
import com.example.demo.repository.model.TbPetExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface TbPetMapper {
    int countByExample(TbPetExample example);

    int deleteByExample(TbPetExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TbPet record);

    int insertSelective(TbPet record);

    List<TbPet> selectByExampleWithRowbounds(TbPetExample example, RowBounds rowBounds);

    List<TbPet> selectByExample(TbPetExample example);

    TbPet selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TbPet record, @Param("example") TbPetExample example);

    int updateByExample(@Param("record") TbPet record, @Param("example") TbPetExample example);

    int updateByPrimaryKeySelective(TbPet record);

    int updateByPrimaryKey(TbPet record);
}