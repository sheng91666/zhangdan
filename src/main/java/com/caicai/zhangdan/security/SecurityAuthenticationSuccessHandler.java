package com.caicai.zhangdan.security;

import com.alibaba.fastjson.JSON;
import com.caicai.zhangdan.entity.UserEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Set;

/**
 * 自定义登录成功类
 */
@Component
public class SecurityAuthenticationSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {
    private Logger logger = LoggerFactory.getLogger(SecurityAuthenticationSuccessHandler.class);

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
            throws IOException, ServletException {
        try {
            Set<String> roles = AuthorityUtils.authorityListToSet(authentication.getAuthorities());
            logger.info("roles集合--{}", JSON.toJSONString(roles));

            //ROLE_1 用户
            if (roles.contains("ROLE_1")) {
                response.sendRedirect("home");
            } else if (roles.contains("ROLE_USER")) {
                response.sendRedirect("user");
            } else {
                response.sendRedirect("main");
            }
        } catch (Exception e) {
            response.sendRedirect("error");
        }
    }

}
