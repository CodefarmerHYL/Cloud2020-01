package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.bean.CommonResult;
import com.atguigu.springcloud.bean.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @Description:
 * @Author 胡菜鸡
 * @Create 2021-11-20-16:30
 */
@RestController
@Slf4j
public class OrderZkController {

    public static final String INVOKE_URL = "http://zookeeper-provider-payment";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping(value = "/consumer/payment/get/{id}")
    public CommonResult<Payment> paymentById(@PathVariable("id") Integer id){
        return restTemplate.getForObject(INVOKE_URL+"/payment/get/"+id, CommonResult.class);
    }

    @GetMapping(value = "/consumer/payment/zk")
    public String paymentInfo(){
        return restTemplate.getForObject(INVOKE_URL+"/payment/zk", String.class);
    }

}
