package com.caicai.zhangdan.mapper;

import com.caicai.zhangdan.entity.UserEntity;
import com.caicai.zhangdan.entity.UserExampleEntity;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserEntity record);

    int insertSelective(UserEntity record);

    List<UserEntity> selectByExample(UserExampleEntity example);

    UserEntity selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") UserEntity record, @Param("example") UserExampleEntity example);

    int updateByExample(@Param("record") UserEntity record, @Param("example") UserExampleEntity example);

    int updateByPrimaryKeySelective(UserEntity record);

    int updateByPrimaryKey(UserEntity record);
}