package com.caicai.zhangdan.config;

import com.caicai.zhangdan.security.SecurityAuthenticationFailHandler;
import com.caicai.zhangdan.security.SecurityAuthenticationProvider;
import com.caicai.zhangdan.security.SecurityAuthenticationSuccessHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.rememberme.TokenBasedRememberMeServices;


@Configuration
@EnableWebSecurity // 注解开启Spring Security的功能
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private Logger logger = LoggerFactory.getLogger(SecurityConfig.class);

    @Autowired
    private SecurityAuthenticationProvider securityAuthenticationProvider;//自定义验证类
    @Autowired
    private SecurityAuthenticationSuccessHandler securityAuthenticationSuccessHandler;//自定义登录成功类
    @Autowired
    private SecurityAuthenticationFailHandler securityAuthenticationFailHandler;//自定义登录失败类

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()//关闭防跨域攻击功能（Cross-site request forgery跨站请求伪造）
                .formLogin().loginPage("/login").loginProcessingUrl("/login-process")
                .successHandler(securityAuthenticationSuccessHandler)//注册登录成功Handler
                .failureHandler(securityAuthenticationFailHandler)//注册登录失败Handler
                .permitAll()
                .and().logout().logoutUrl("/logout")//定义注销url
                .invalidateHttpSession(true)
                .clearAuthentication(true)
                .and().authorizeRequests().antMatchers("/", "/error", "/error/*", "/**/*.*")//注册不需要拦截的url
                .permitAll().anyRequest().authenticated();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(securityAuthenticationProvider);//注册自定义登录验证
    }

    @Bean
    public TokenBasedRememberMeServices tokenBasedRememberMeServices() {
        return new TokenBasedRememberMeServices("springRocks", userDetailsService());
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() { //密码加密
        return new BCryptPasswordEncoder(4);
    }
}
