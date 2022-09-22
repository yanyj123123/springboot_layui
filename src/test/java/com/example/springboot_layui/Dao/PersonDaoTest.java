package com.example.springboot_layui.Dao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class PersonDaoTest {
    @Autowired
    public PersonDao personDao;
    @Test
    void person()
    {

       personDao.selectById(1);
    }

    @Test
    void check() {
        personDao.check("yanjie","123456");
    }
}