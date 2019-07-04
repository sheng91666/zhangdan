package com.caicai.zhangdan.security;

import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

/**
 * 自定义验证类
 */
@Component
public class SecurityAuthenticationProvider implements AuthenticationProvider {
    private Logger logger = LoggerFactory.getLogger(SecurityAuthenticationProvider.class);
    @Autowired
    SecurityUserDetailService securityUserDetailService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        logger.info("authentication--{}", JSON.toJSONString(authentication));

        String username = authentication.getName().trim();
        String password = authentication.getCredentials().toString();

        //查询数据库
        SecurityUser securityUser = (SecurityUser) securityUserDetailService.loadUserByUsername(username);
        logger.info("securityUser--{}", JSON.toJSONString(securityUser));

        if (securityUser == null) {
            throw new DisabledException("账号不存在！");
        }
        if (!securityUser.getPassword().equals(password)) {
            throw new BadCredentialsException("密码不正确！");
        }

        return new UsernamePasswordAuthenticationToken(username, password, securityUser.getAuthorities());
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return true;
    }
}
