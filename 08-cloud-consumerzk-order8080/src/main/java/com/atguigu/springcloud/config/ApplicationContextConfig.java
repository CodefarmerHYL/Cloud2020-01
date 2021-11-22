package com.atguigu.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @Description:
 * @Author 胡菜鸡
 * @Create 2021-11-20-16:29
 */
@Configuration
public class ApplicationContextConfig {

    @Bean
    @LoadBalanced   //负载平衡
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

}
