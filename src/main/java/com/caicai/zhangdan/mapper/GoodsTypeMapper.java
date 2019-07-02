package com.caicai.zhangdan.mapper;

import com.caicai.zhangdan.entity.GoodsTypeEntity;
import com.caicai.zhangdan.entity.GoodsTypeExampleEntity;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GoodsTypeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(GoodsTypeEntity record);

    int insertSelective(GoodsTypeEntity record);

    List<GoodsTypeEntity> selectByExample(GoodsTypeExampleEntity example);

    GoodsTypeEntity selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") GoodsTypeEntity record, @Param("example") GoodsTypeExampleEntity example);

    int updateByExample(@Param("record") GoodsTypeEntity record, @Param("example") GoodsTypeExampleEntity example);

    int updateByPrimaryKeySelective(GoodsTypeEntity record);

    int updateByPrimaryKey(GoodsTypeEntity record);
}