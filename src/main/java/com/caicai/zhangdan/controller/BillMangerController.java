package com.caicai.zhangdan.controller;

import com.caicai.zhangdan.entity.BillEntity;
import com.caicai.zhangdan.vo.BillResponse;
import org.springframework.stereotype.Controller;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/")
public class BillMangerController {

    /**
     * 是否登录
     *
     * @param request
     * @return
     */
    public Boolean isLogin(HttpServletRequest request) {
        Boolean isLogin = false;
        if (ObjectUtils.isEmpty(request.getUserPrincipal())) {
            isLogin = false;
        } else {
            isLogin = true;
        }
        return isLogin;
    }

    /**
     * 判断是否登录
     * |--登录--跳首页
     * |--未登录--跳登录页
     *
     * @param request
     * @return
     */
    @RequestMapping("/index")
    public ModelAndView index(HttpServletRequest request) {

        ModelAndView mv = new ModelAndView();
        Boolean login = this.isLogin(request);
        if(login){
            mv.setViewName("home");
        }else {
            mv.setViewName("login");
        }
        return mv;
    }

    @RequestMapping("/queryAll")
    @ResponseBody
    public BillResponse queryAll(String param,HttpServletRequest request){





        return null;
    }

}
