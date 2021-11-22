package com.atguigu.springcloud.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description: 开启 feign 的接口日志调用
 * @Author 胡菜鸡
 * @Create 2021-11-21-21:20
 */
@Configuration
public class FeignConfig {

    @Bean
    Logger.Level feignLoggerLevel(){
        return Logger.Level.FULL;   //开启详细日志
    }

}
