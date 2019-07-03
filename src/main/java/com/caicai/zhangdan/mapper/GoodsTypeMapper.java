package com.caicai.zhangdan.mapper;

import com.caicai.zhangdan.entity.GoodsTypeEntity;

public interface GoodsTypeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(GoodsTypeEntity record);

    int insertSelective(GoodsTypeEntity record);

    GoodsTypeEntity selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(GoodsTypeEntity record);

    int updateByPrimaryKey(GoodsTypeEntity record);
}