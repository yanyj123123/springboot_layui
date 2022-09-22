package com.example.springboot_layui.Dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.springboot_layui.entity.ProductEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProductDao extends BaseMapper<ProductEntity> {
}
