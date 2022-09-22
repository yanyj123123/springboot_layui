package com.example.springboot_layui.Dao;

import com.example.springboot_layui.vo.ProductBarVo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ProductBarVODaoTest {
    @Autowired
    ProductBarVODao productBarVODao;

    @Test
    void findAll() {
        List<ProductBarVo> list=productBarVODao.findAllProductBarVo();
        int i=0;
    }
}