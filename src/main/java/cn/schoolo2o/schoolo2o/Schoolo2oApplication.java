package cn.schoolo2o.schoolo2o;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(value = "cn.schoolo2o.schoolo2o.mapper")
public class Schoolo2oApplication {

    public static void main(String[] args) {
        SpringApplication.run(Schoolo2oApplication.class, args);
    }
}
