package com.example.springboot_layui.Dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.springboot_layui.entity.PersonEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface PersonDao extends BaseMapper<PersonEntity> {
    @Select("select *from person where username=#{username} and password=#{password}")
    public PersonEntity check(@Param("username") String username,@Param("password") String password);


}
