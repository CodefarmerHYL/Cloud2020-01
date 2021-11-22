package com.atguigu.springcloud.service;

import com.atguigu.springcloud.bean.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @Description:
 * @Author 胡菜鸡
 * @Create 2021-11-17-14:49
 */
public interface PaymentService {

    public int create(Payment payment);

    public Payment getPaymentById(@Param("id") Long id);

}
