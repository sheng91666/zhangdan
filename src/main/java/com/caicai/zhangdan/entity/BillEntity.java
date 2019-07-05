package com.caicai.zhangdan.entity;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class BillEntity {
    private Integer id;

    private String billCode;

    private String goodsName;

    private String goodsCode;

    private String billType;

    private String billTime;

    private BigDecimal price;

    private String remark;

    private String deleteFlag;

    private Date createDate;

    private String createPerson;

    private Date updateDate;

    private String updatePerson;


}