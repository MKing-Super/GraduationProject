package com.mkinfo.carhouse;

import com.mkinfo.carhouse.sys.model.SysSaleCar;
import com.mkinfo.carhouse.sys.service.SysSaleCarService;
import org.junit.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
@MapperScan(basePackages = "com.mkinfo.carhouse.**.dao")
public class CarhouseApplication {
    public static void main(String[] args) {
        SpringApplication.run(CarhouseApplication.class, args);
    }

}
