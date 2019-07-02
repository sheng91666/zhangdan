package com.caicai.zhangdan.controller;

import com.alibaba.fastjson.JSON;
import com.caicai.zhangdan.entity.UserEntity;
import com.caicai.zhangdan.service.LoginService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class LoginController {

    private Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private LoginService loginService;

    @RequestMapping("/login")
    @ResponseBody
    public Map<String, String> login(String userName, String passWord) {

        Map<String, String> map = new HashMap<>();
        UserEntity user = new UserEntity();
        user.setUserName(userName);
        logger.info("登录查询--参数：{}", JSON.toJSONString(user));
        UserEntity userEntity = loginService.queryUserByUser(user);
        logger.info("登录查询--返回：{}", JSON.toJSONString(userEntity));

        if (!ObjectUtils.isEmpty(userEntity)) {
            if (passWord.equals(userEntity.getPassWord())) {
                map.put("status", "1");
            } else {
                map.put("status", "0");
                map.put("message", "账号或密码错误！");
            }
        } else {
            map.put("status", "0");
            map.put("message", "不存在该账号！");
        }

        return map;
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
