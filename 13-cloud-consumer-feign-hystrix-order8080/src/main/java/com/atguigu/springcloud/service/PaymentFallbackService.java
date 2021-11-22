package com.atguigu.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * @Description:
 * @Author 胡菜鸡
 * @Create 2021-11-22-15:19
 */
@Component
public class PaymentFallbackService implements PaymentHystrixService {
    @Override
    public String paymentInfo_OK(Integer id) {
        return "------PaymentFallbackService fall back-paymentInfo-OK";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "------PaymentFallbackService fall back-paymentInfo-TimeOut";
    }
}
