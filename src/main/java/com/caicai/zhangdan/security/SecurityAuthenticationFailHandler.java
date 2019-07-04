package com.caicai.zhangdan.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class SecurityAuthenticationFailHandler extends SimpleUrlAuthenticationFailureHandler {
	private Logger logger = LoggerFactory.getLogger(SecurityAuthenticationFailHandler.class);
	@Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
    		AuthenticationException exception) throws IOException, ServletException {
		logger.info("SecurityAuthenticationFailHandler--自定义错误！");
		request.getSession().setAttribute("errMsg", exception.getMessage());
		response.sendRedirect("/login");
	}
}
