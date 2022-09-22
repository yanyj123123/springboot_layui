package com.example.springboot_layui.Controller;

import com.example.springboot_layui.Dao.PersonDao;
import com.example.springboot_layui.Service.ProductService;
import com.example.springboot_layui.entity.PersonEntity;
import com.example.springboot_layui.vo.BarVo;
import com.example.springboot_layui.vo.DataVo;
import com.example.springboot_layui.vo.ProductPieVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@CrossOrigin
public class ProductController {
    @Autowired
    private ProductService productService;

    @Autowired
    private PersonDao personDao;
    @RequestMapping("/list")
    @ResponseBody
    public DataVo list(Integer page, Integer limit){
        DataVo dataVo= productService.findDate(page, limit);
        return dataVo;
    }

    @GetMapping("/{url}")
    public String index(@PathVariable("url")String url){
        return url;
    }

    @RequestMapping("/Echarts")
    @ResponseBody
    public BarVo Echarts(){
        return productService.getBarVo();
    }

    @RequestMapping("/PieVo")
    @ResponseBody
    public List<ProductPieVo>get(){
        return productService.getPieVo();
    }


    @GetMapping(value="/login")
    @ResponseBody
    @CrossOrigin
    public String Login(@RequestBody PersonEntity personEntity) {
        PersonEntity personEntityCheck =personDao.check(personEntity.getUsername(),personEntity.getPassword());
        System.out.println(personEntity.getUsername());
        return "error";
    }

}
