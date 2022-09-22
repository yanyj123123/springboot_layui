package com.example.springboot_layui.ServiceImpl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.springboot_layui.Dao.ProductBarVODao;
import com.example.springboot_layui.Dao.ProductCategoryDao;
import com.example.springboot_layui.Dao.ProductDao;
import com.example.springboot_layui.Service.ProductService;
import com.example.springboot_layui.entity.ProductEntity;
import com.example.springboot_layui.vo.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductDao productDao;
    @Autowired
    private ProductCategoryDao productCategoryDao;

    @Override
    public DataVo<ProductVo> findDate(Integer page, Integer limit) {
        DataVo dataVo = new DataVo();
        dataVo.setCode(0);
        dataVo.setMsg("");

        //分页,必须使用拦截器，见Mybpconfig
        IPage<ProductEntity> page1 = new Page<>(page, limit);
        IPage<ProductEntity> result = productDao.selectPage(page1, null);

        dataVo.setCount(result.getTotal());
        List<ProductEntity> productList = result.getRecords();

        //不分页
        //List<ProductEntity> productList=productDao.selectList(null);
        //dataVo.setCount(productDao.selectCount(null));
        List<ProductVo> productVoList = new ArrayList<>();
        for (ProductEntity productEntity : productList) {
            ProductVo productVo = new ProductVo();
            BeanUtils.copyProperties(productEntity, productVo);
            QueryWrapper queryWrapper = new QueryWrapper();
            queryWrapper.eq("id", productEntity.getCategoryleveloneId());
            productVo.setCategorylevelone(productCategoryDao.selectOne(queryWrapper).getName());
            queryWrapper = new QueryWrapper();
            queryWrapper.eq("id", productEntity.getCategoryleveltwoId());
            productVo.setCategoryleveltwo(productCategoryDao.selectOne(queryWrapper).getName());
            queryWrapper = new QueryWrapper();
            queryWrapper.eq("id", productEntity.getCategorylevelthreeId());
            productVo.setCategorylevelthree(productCategoryDao.selectOne(queryWrapper).getName());
            productVoList.add(productVo);
        }
        dataVo.setData(productVoList);

        return dataVo;
    }

    @Autowired
    ProductBarVODao productBarVODao;

    @Override
    public BarVo getBarVo() {

        List<ProductBarVo> list = productBarVODao.findAllProductBarVo();
        List<String> names = new ArrayList<>();
        List<Integer> count = new ArrayList<>();
        for (ProductBarVo productBarVo : list) {
            names.add(productBarVo.getName());
            count.add(productBarVo.getCount());
        }
        BarVo barVo = new BarVo();
        barVo.setNames(names);
        barVo.setValues(count);
        return barVo;
    }

    @Override
    public List<ProductPieVo> getPieVo() {
        List<ProductBarVo> list = productBarVODao.findAllProductBarVo();
        List<ProductPieVo> pieVoList = list.stream()
                .map(e -> new ProductPieVo(
                        e.getCount(),
                        e.getName()
                )).collect(Collectors.toList());
        return pieVoList;
    }
}


