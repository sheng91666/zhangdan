package com.caicai.zhangdan.vo;

import com.github.pagehelper.PageInfo;
import lombok.Data;

@Data
public class BillResponse {

    private String status;

    private String message;

    private PageInfo<BillAndGoodsVo> pageInfo;

}
