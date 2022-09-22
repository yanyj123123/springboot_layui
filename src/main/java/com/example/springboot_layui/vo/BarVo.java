package com.example.springboot_layui.vo;

import lombok.Data;

import java.util.List;

@Data
public class BarVo {
    private List<String> names;
    private List<Integer>values;
}
