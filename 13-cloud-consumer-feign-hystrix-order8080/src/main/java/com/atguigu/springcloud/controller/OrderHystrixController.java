package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.service.PaymentHystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Description: 消费者服务降级
 * @Author 胡菜鸡
 * @Create 2021-11-21-23:23
 */
@RestController
@DefaultProperties(defaultFallback = "paymentInfo_FallbackMethod")  //指定默认服务降级的处理方法
public class OrderHystrixController {

    @Resource
    private PaymentHystrixService paymentHystrixService;

    @GetMapping(value = "/consumer/payment/hystrix/ok/{id}")
    public String paymentInfo_OK(@PathVariable("id") Integer id){
        String result = paymentHystrixService.paymentInfo_OK(id);
        return result;
    }

    /**
     * 服务降级处理
     * @author 胡菜鸡
     * @date 2021/11/22 15:05
     */
    @GetMapping(value = "/consumer/payment/hystrix/timeout/{id}")
//    @HystrixCommand(fallbackMethod = "paymentInfo_TimeOutHandler", commandProperties = {
//            //规定线程的超时时间为1.5s
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1500")
//    })
    @HystrixCommand     //未指定服务降级的处理方法，则使用默认的
    public String paymentInfo_TimeOut(@PathVariable("id") Integer id){
        String result = paymentHystrixService.paymentInfo_TimeOut(id);
        return result;
    }
//    public String paymentInfo_TimeOutHandler(@PathVariable("id") Integer id){
//        return "消费者8080，对方支付系统繁忙请稍后再试";
//    }

    /**
     * 设置默认的全局处理 fallback 服务降级的方法
     * @author 胡菜鸡
     * @date 2021/11/22 15:10
     */
    public String paymentInfo_FallbackMethod(){
        return "消费者8080的默认服务降级处理方法";
    }


}
