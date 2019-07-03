package com.caicai.zhangdan.mapper;

import com.caicai.zhangdan.entity.BillEntity;

public interface BillMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BillEntity record);

    int insertSelective(BillEntity record);

    BillEntity selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BillEntity record);

    int updateByPrimaryKey(BillEntity record);
}