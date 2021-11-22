package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.bean.CommonResult;
import com.atguigu.springcloud.bean.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import sun.rmi.runtime.Log;

import javax.annotation.Resource;

/**
 * @Description:
 * @Author 胡菜鸡
 * @Create 2021-11-17-16:06
 */
@RestController
@Slf4j
public class OrderController {

    //调用的地址
//    public static final String PAYMENT_URL = "http://localhost:8001";
    //访问eureka上登录的服务（即 yml 中配置的 spring.application.name）
    public static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";

    //从IOC容器中获取一个 RestTemplate 对象（用于发送GET/POST请求）
    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/consumer/payment/create")     //用户发送的都是get请求
    public CommonResult<Payment> create(Payment payment){
        log.info("********" + payment);
        //发送一个 post 请求（参数分别为：发送地址、参数、返回值对象）
        return restTemplate.postForObject(PAYMENT_URL+"/payment/create", payment, CommonResult.class);
    }

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){
        return restTemplate.getForObject(PAYMENT_URL+"/payment/get/"+id, CommonResult.class);
    }

    @GetMapping("/consumer/payment/getForEntity/{id}")
    public CommonResult<Payment> getPaymentById2(@PathVariable("id") Long id){
        ResponseEntity<CommonResult> entity = restTemplate.getForEntity(PAYMENT_URL + "/payment/get/" + id, CommonResult.class);
        if(entity.getStatusCode().is2xxSuccessful()){
            log.info(entity + "");
            return entity.getBody();
        } else {
            return new CommonResult<>(444, "操作失败");
        }
    }

}
