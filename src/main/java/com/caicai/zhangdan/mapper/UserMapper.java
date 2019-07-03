package com.caicai.zhangdan.mapper;

import com.caicai.zhangdan.entity.UserEntity;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insertSelective(UserEntity record);

    UserEntity selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserEntity record);
}