package com.caicai.zhangdan.controller;

import com.alibaba.fastjson.JSON;
import com.caicai.zhangdan.entity.BillEntity;
import com.caicai.zhangdan.entity.UserEntity;
import com.caicai.zhangdan.service.BillService;
import com.caicai.zhangdan.vo.BillAndGoodsVo;
import com.caicai.zhangdan.vo.BillCommand;
import com.caicai.zhangdan.vo.BillResponse;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@Controller
public class BillMangerController {
    private Logger logger = LoggerFactory.getLogger(BillMangerController.class);

    @Autowired
    private BillService billService;

    private Authentication getAuthentication(HttpServletRequest request) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication;
    }

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
    @RequestMapping("/home")
    public ModelAndView index(HttpServletRequest request) {

        ModelAndView mv = new ModelAndView();
        Boolean login = this.isLogin(request);
        if (login) {
            mv.setViewName("home");
        } else {
            mv.setViewName("login");
        }
        return mv;
    }

    @RequestMapping("/queryAll")
    @ResponseBody
    public BillResponse queryAll(@RequestParam("lFlag") String billType,
                                 @RequestParam("pageSize")Integer pageSize,
                                 @RequestParam("pageNum")Integer pageNum,
                                 HttpServletRequest request) {
        Authentication authentication = this.getAuthentication(request);
        String userName = authentication.getName().trim();

        BillCommand billCommand = new BillCommand();
        billCommand.setBillType(Integer.valueOf(billType));
        billCommand.setPageNum(pageNum);
        billCommand.setPageSize(pageSize);
        billCommand.setUserName(userName);

        logger.info("根据用户名查询所有账单--参数：{}", JSON.toJSONString(billCommand));
        PageInfo<BillAndGoodsVo> billAndGoodsVoPageInfo = billService.queryAllByUser(billCommand);
        logger.info("根据用户名查询所有账单--返回：{}", JSON.toJSONString(billAndGoodsVoPageInfo));

        BillResponse billResponse = new BillResponse();
        billResponse.setPageInfo(billAndGoodsVoPageInfo);
        return billResponse;
    }

    @RequestMapping("/saveZD")
    @ResponseBody
    public Integer saveZD(@RequestParam("data") String data, HttpServletRequest request) {
        Authentication authentication = this.getAuthentication(request);
        String userName = authentication.getName().trim();

        logger.info("新增账单--页面传参：{}", data);
        if (!ObjectUtils.isEmpty(data)) {
            BillEntity billEntity = JSON.parseObject(data, BillEntity.class);
            billEntity.setCreateDate(new Date());
            billEntity.setCreatePerson(userName);
            logger.info("新增账单--参数：{}", JSON.toJSONString(billEntity));
            return billService.saveZD(billEntity);
        }
        return 0;
    }


}
