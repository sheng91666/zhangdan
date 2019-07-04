package com.caicai.zhangdan.security;

import com.alibaba.fastjson.JSON;
import com.caicai.zhangdan.entity.UserEntity;
import com.caicai.zhangdan.service.LoginService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class SecurityUserDetailService implements UserDetailsService {
    private Logger logger = LoggerFactory.getLogger(SecurityUserDetailService.class);
    @Autowired
    private LoginService loginService;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        UserEntity user = new UserEntity();
        user.setUserName(userName);
        logger.info("根据用户名查询用户--参数：{}", user);
        UserEntity userResponse = loginService.queryUserByUser(user);
        logger.info("根据用户名查询用户--返回：{}", JSON.toJSONString(userResponse));
        if (userResponse == null) {
            throw new UsernameNotFoundException("Username " + userName + " not found");
        }
        return new SecurityUser(userResponse);
    }
}
