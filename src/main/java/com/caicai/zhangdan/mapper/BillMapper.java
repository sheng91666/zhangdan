package com.caicai.zhangdan.mapper;

import com.caicai.zhangdan.entity.BillEntity;
import com.caicai.zhangdan.entity.BillExampleEntity;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BillMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BillEntity record);

    int insertSelective(BillEntity record);

    List<BillEntity> selectByExample(BillExampleEntity example);

    BillEntity selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") BillEntity record, @Param("example") BillExampleEntity example);

    int updateByExample(@Param("record") BillEntity record, @Param("example") BillExampleEntity example);

    int updateByPrimaryKeySelective(BillEntity record);

    int updateByPrimaryKey(BillEntity record);
}