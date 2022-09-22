package com.example.springboot_layui.Dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.springboot_layui.entity.ProductCategoryEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProductCategoryDao extends BaseMapper<ProductCategoryEntity> {
}
