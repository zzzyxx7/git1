package org.example.springbootmybatisquickstart;

import org.example.Mapper.UserMapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackageClasses = UserMapper.class)
public class SpringbootMybatisQuickstartApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootMybatisQuickstartApplication.class, args);
    }

}
