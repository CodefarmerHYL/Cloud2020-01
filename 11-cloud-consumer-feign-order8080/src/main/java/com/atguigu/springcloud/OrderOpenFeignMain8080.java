package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients     //开启openfeign
public class OrderOpenFeignMain8080 {

    public static void main(String[] args) {
        SpringApplication.run(OrderOpenFeignMain8080.class, args);
    }

}
