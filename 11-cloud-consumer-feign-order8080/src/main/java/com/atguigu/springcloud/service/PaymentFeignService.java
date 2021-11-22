package com.atguigu.springcloud.service;

import com.atguigu.springcloud.bean.CommonResult;
import com.atguigu.springcloud.bean.Payment;
import feign.Param;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Description: 微服务接口 openfeign：
 *                  通过openfeign可以直接调用其他module中类的方法（远程调用）
 *                  openfeign自带负载均衡
 *                  通过 @FeignClient(value = "CLOUD-PAYMENT-SERVICE") 指定调用的是哪个module
 * @Author 胡菜鸡
 * @Create 2021-11-21-20:12
 */
@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")       //feign寻找的微服务地址
public interface PaymentFeignService {

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id);


    @GetMapping(value = "/payment/feign/timeout")
    public String paymentFeignTimeOut();
}
