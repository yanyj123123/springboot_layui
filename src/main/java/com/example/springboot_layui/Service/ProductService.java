package com.example.springboot_layui.Service;

import com.example.springboot_layui.vo.BarVo;
import com.example.springboot_layui.vo.DataVo;
import com.example.springboot_layui.vo.ProductPieVo;
import com.example.springboot_layui.vo.ProductVo;

import java.util.List;

public interface ProductService {
    public DataVo<ProductVo> findDate(Integer page,Integer limit);
    public BarVo getBarVo();
    public List<ProductPieVo> getPieVo();
}
