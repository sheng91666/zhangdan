package com.caicai.zhangdan.vo;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class BillAndGoodsVo implements Serializable {

    private static final long serialVersionUID = 5195813181979585457L;

    private Integer billId;

    private String billCode;

    private String goodsName;

    private String goodsCode;

    private String billTime;

    private String billType;

    private BigDecimal price;

    private String remark;

    private String goodsType;

}
