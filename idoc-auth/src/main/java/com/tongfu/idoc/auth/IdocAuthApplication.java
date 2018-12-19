package com.tongfu.idoc.auth;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
@ServletComponentScan
@MapperScan("com.tongfu.idoc.auth.mapper")
public class IdocAuthApplication {

    public static void main(String[] args) {
        SpringApplication.run(IdocAuthApplication.class, args);
    }

}

