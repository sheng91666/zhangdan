package com.caicai.zhangdan.entity;

import lombok.Data;

import java.util.Date;

@Data
public class UserEntity {
    private Integer id;

    private String userName;

    private String userCode;

    private String userImage;

    /**
     * 上次登录ip
     */
    private String lastIp;

    /**
     * 上次登录时间
     */
    private String lastTime;

    /**
     * 角色 0管理员 1用户
     */
    private String role;

    private String phone;

    private String passWord;

    private String email;

    /**
     * 注册时间
     */
    private Date createDate;

    /**
     * 1删除 0未删除
     */
    private String deleteFlag;
}