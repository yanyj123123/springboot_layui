package com.example.springboot_layui.Dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.springboot_layui.entity.ProductEntity;
import com.example.springboot_layui.vo.ProductBarVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
@Mapper
public interface ProductBarVODao extends BaseMapper<ProductEntity> {
    @Select("select p.name,sum(o.quantity) count from order_detail o,product p where o.product_id=p.id group by product_id")
    public List<ProductBarVo> findAllProductBarVo();
}
