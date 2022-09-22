package com.example.springboot_layui.Service;

import com.example.springboot_layui.Dao.ProductDao;
import com.example.springboot_layui.vo.DataVo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class ProductServiceTest {

    @Autowired
    private ProductService productService;
    @Test
    void findDate() {


    }

    @Test
    void getBarVo() {
        productService.getBarVo();
    }
}