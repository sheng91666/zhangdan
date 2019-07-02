package com.caicai.zhangdan.service.impl;

import com.caicai.zhangdan.entity.UserEntity;
import com.caicai.zhangdan.mapper.UserMapper;
import com.caicai.zhangdan.mapper.UserPlusMapper;
import com.caicai.zhangdan.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private UserPlusMapper userPlusMapper;

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserEntity queryUserByUser(UserEntity user) {
        return userPlusMapper.queryUserByUser(user);
    }

    @Override
    public int signInByUser(UserEntity userEntity) {

        String uuid = UUID.randomUUID().toString().replace("-", "");
        userEntity.setUserCode(uuid);
        return userMapper.insertSelective(userEntity);
    }
}
