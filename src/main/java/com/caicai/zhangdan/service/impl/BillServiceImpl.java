package com.caicai.zhangdan.service.impl;

import com.caicai.zhangdan.entity.BillEntity;
import com.caicai.zhangdan.mapper.BillMapper;
import com.caicai.zhangdan.service.BillService;
import com.caicai.zhangdan.vo.BillAndGoodsVo;
import com.caicai.zhangdan.vo.BillCommand;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BillServiceImpl implements BillService {

    @Autowired
    private BillMapper billMapper;

    @Override
    public PageInfo<BillAndGoodsVo> queryAllByUser(BillCommand command) {

        PageHelper.startPage(command.getPageNum(), command.getPageSize());
        List<BillAndGoodsVo> list = billMapper.queryAllByUser(command);
        PageInfo<BillAndGoodsVo> pageInfo = new PageInfo<>();
        pageInfo.setList(list);
        return pageInfo;
    }

    @Override
    public int saveZD(BillEntity billEntity) {
        return billMapper.insertSelective(billEntity);
    }

    @Override
    public int deleteBillById(Integer id) {
        return billMapper.deleteByPrimaryKey(id);
    }

    @Override
    public PageInfo<BillAndGoodsVo> queryBySearch(String priceFlag, String startTime, String endTime) {
        PageHelper.startPage(0, 10);
        List<BillAndGoodsVo> billAndGoodsVos = billMapper.queryBySearch(priceFlag, startTime, endTime);
        PageInfo<BillAndGoodsVo> billAndGoodsVoPageInfo = new PageInfo<>();
        billAndGoodsVoPageInfo.setList(billAndGoodsVos);
        return billAndGoodsVoPageInfo;
    }
}
