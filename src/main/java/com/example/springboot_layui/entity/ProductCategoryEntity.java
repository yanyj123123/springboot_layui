package com.example.springboot_layui.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("product_category")
public class ProductCategoryEntity {
    private Integer id;
    private String name;
    private Integer parent_id;
    private Integer type;

}
