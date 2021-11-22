package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 开启consul：找到consul.ext，在此文件对应的目录下cmd运行：consul agent -dev
 * @author 胡菜鸡
 * @date 2021/11/20 17:39
 */
@SpringBootApplication
@EnableDiscoveryClient
public class OrderMain8080 {

    public static void main(String[] args) {
        SpringApplication.run(OrderMain8080.class, args);
    }

}
