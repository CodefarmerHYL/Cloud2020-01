package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.bean.CommonResult;
import com.atguigu.springcloud.bean.Payment;
import com.atguigu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * @Description:
 * @Author 胡菜鸡
 * @Create 2021-11-20-15:51
 */
@RestController
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @RequestMapping(value = "/payment/consul")
    public String paymentConsul(){
        return "springcloud with consul:" + serverPort + "\t" + UUID.randomUUID().toString();
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){
        Payment payment = paymentService.getPaymentById(id);
        log.info("******结果：" + payment + "\t" + "O(∩_∩)O哈哈~");

        if(payment != null){
            return new CommonResult(200, "查询成功，serverPort："+serverPort, payment);
        } else {
            return new CommonResult(444, "不存在记录" + id);
        }
    }

}
