package com.example.springboot_layui.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("person")
public class PersonEntity {
    Integer id;
    String username;
    String password;
}
