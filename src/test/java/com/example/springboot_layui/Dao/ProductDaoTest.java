package com.example.springboot_layui.Dao;

import com.example.springboot_layui.entity.ProductEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class ProductDaoTest {
    @Autowired
    private ProductDao productDao;
    @Test
    void test(){
        productDao.selectList(null).forEach(System.out::println);
    }
}