package com.caicai.zhangdan.controller;

import com.alibaba.fastjson.JSON;
import com.caicai.zhangdan.entity.UserEntity;
import com.caicai.zhangdan.service.LoginService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Controller
public class LoginController {

    private Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private LoginService loginService;

    @RequestMapping("/login")
    public ModelAndView hello(Model model, HttpServletRequest request){

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && !authentication.getName().equalsIgnoreCase("anonymousUser")) {
            Set<String> roles = AuthorityUtils.authorityListToSet(authentication.getAuthorities());
            //根据登录用户权限跳转默认页面
            if (roles.contains("ROLE_1")) {
                return new ModelAndView("home");
            } else if (roles.contains("ROLE_USER")) {
                return new ModelAndView("redirect:user");
            } else if (roles.contains("ROLE_OHTER")) {
                return new ModelAndView("redirect:main");
            }
        }
        HttpSession session = request.getSession(false);
        if (session != null) {
            Object errMsg = session.getAttribute("errMsg");
            if (errMsg != null) {
                model.addAttribute("errMsg", errMsg);
                session.removeAttribute("errMsg");
            }
        }
        return new ModelAndView("login");
    }

    //为了session从获取用户信息,可以配置如下
    public UserEntity getUser() {
        UserEntity user = new UserEntity();
        SecurityContext ctx = SecurityContextHolder.getContext();
        Authentication auth = ctx.getAuthentication();
        if (auth.getPrincipal() instanceof UserDetails) {
            user = (UserEntity) auth.getPrincipal();
        }
        return user;
    }

    @RequestMapping("/signIn")
    @ResponseBody
    public Map<String, String> signIn(@RequestParam("user") String param) {
        UserEntity userEntity = JSON.parseObject(param, UserEntity.class);
        logger.info("注册参数：{}", JSON.toJSONString(userEntity));
        int i = loginService.signInByUser(userEntity);

        Map<String, String> map = new HashMap<>();
        if (1 != i) {
            map.put("0", "注册失败！");
        } else {
            map.put("1", "注册成功！");
        }
        return map;
    }
}
