package com.example.springboot_layui;

import com.example.springboot_layui.Dao.ProductDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringbootLayuiApplicationTests {

    @Autowired
    private ProductDao productDao;
    @Test
    void test(){
        productDao.selectList(null).forEach(System.out::println);
    }

}
