package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 网关：通过网关访问，可以起到隐藏真实地址的作用
 *      如：开启 04、01、15后
 *          http://localhost:8001/payment/get/2 和 http://localhost:9527/payment/get/2 相同
 * @author 胡菜鸡
 * @date 2021/11/22 17:34
 */
@SpringBootApplication
@EnableEurekaClient
public class GatewayMain9527 {

    public static void main(String[] args) {
        SpringApplication.run(GatewayMain9527.class, args);
    }

}
