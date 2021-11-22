package com.atguigu.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @Description:
 * @Author 胡菜鸡
 * @Create 2021-11-17-16:10
 */
@Configuration
public class ApplicationContextConfig {

    /**
     * 向IOC容器中添加一个 RestTemplate 对象（用于发送GET/POST请求）
     * @author 胡菜鸡
     * @date 2021/11/17 16:10
     */
    @Bean
    @LoadBalanced   //开启负载均衡机制（不开启在面对多台服务提供者时会报错）
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }



}
