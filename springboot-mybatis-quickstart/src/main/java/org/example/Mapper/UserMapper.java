package org.example.Mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.example.pojo.User;

import java.util.List;

@Mapper //应用程序在运行时，会自动创建UserMapper接口的实现类对象，并交给spring管理
public interface UserMapper {
    @Select("select * from emp")
     List<User> findAll();

}
