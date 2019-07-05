package com.caicai.zhangdan.service;

import com.caicai.zhangdan.entity.BillEntity;
import com.caicai.zhangdan.vo.BillAndGoodsVo;
import com.caicai.zhangdan.vo.BillCommand;
import com.github.pagehelper.PageInfo;

public interface BillService {

    PageInfo<BillAndGoodsVo> queryAllByUser(BillCommand command);

    int saveZD(BillEntity billEntity);

}
