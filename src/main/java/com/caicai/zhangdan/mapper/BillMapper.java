package com.caicai.zhangdan.mapper;

import com.caicai.zhangdan.entity.BillEntity;
import com.caicai.zhangdan.vo.BillAndGoodsVo;
import com.caicai.zhangdan.vo.BillCommand;

import java.util.List;

public interface BillMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BillEntity record);

    int insertSelective(BillEntity record);

    BillEntity selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BillEntity record);

    int updateByPrimaryKey(BillEntity record);

    List<BillAndGoodsVo> queryAllByUser(BillCommand command);
}