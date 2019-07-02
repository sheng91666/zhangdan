package com.caicai.zhangdan.service;

import com.caicai.zhangdan.entity.UserEntity;

public interface LoginService {
    UserEntity queryUserByUser(UserEntity user);

    int signInByUser(UserEntity userEntity);
}
