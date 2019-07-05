package com.caicai.zhangdan.vo;

import com.caicai.zhangdan.entity.UserEntity;
import lombok.Data;

@Data
public class BillCommand extends UserEntity {

    private Integer pageSize;

    private Integer pageNum;
    /**
     * 1:收入 0：支出
     */
    private Integer billType;
}
