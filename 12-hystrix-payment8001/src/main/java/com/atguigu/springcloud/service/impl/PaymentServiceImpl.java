package com.atguigu.springcloud.service.impl;

import com.atguigu.springcloud.service.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.cloud.commons.util.IdUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @Description: 服务降级的处理方式
 * @Author 胡菜鸡
 * @Create 2021-11-21-21:55
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    /**
     * 正常访问，肯定 OK
     * @author 胡菜鸡
     * @date 2021/11/21 21:57
     */
    public String paymentInfo_OK(Integer id){
        return "线程池：" + Thread.currentThread().getName() + "\tpaymentInfo_OK，id：" + id;
    }

    /**
     * 模拟超时.
     * 服务降级的处理方式：@HystrixCommand(fallbackMethod = "兜底的方法名", commandProperties = {服务降级的属性(多个)})
     *
     * @author 胡菜鸡
     * @date 2021/11/21 21:58
     */
    @HystrixCommand(fallbackMethod = "paymentInfo_TimeOutHandler", commandProperties = {
            //规定线程的超时时间为2s
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "4000")
    })
    public String paymentInfo_TimeOut(Integer id){
        int timeNumber = 2;
        try {
            TimeUnit.SECONDS.sleep(timeNumber);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        int age = 10/0;
        return "线程池：" + Thread.currentThread().getName() + "\tpaymentInfo_TimeOut，id：" + id;
    }
    public String paymentInfo_TimeOutHandler(Integer id){
        return "线程池：" + Thread.currentThread().getName() + "\tpaymentInfo_TimeOutHandler，id：" + id;
    }

    /**
     * 服务熔断：过程为  服务降级 -> 进而熔断 -> 慢慢恢复调用链路。
     *      服务熔断的条件：
     *          1.在一定时间以内过于拥挤（这里设置为10秒）
     *          2.满足一定阈值（这里设置为10秒内有超过10个请求）
     *          3.失败率达到一定值（这里设置的为60%，即10次失败6次以上）
     *
     *      满足熔断条件后：
     *          1.断路器开启，所有请求都不会转发
     *          2.一段时间后，断路器进入半开状态，会让其中一个请求进行转发
     *          3.转发成功则关闭断路器，否则继续上面两个步骤
     *
     * @author 胡菜鸡
     * @date 2021/11/22 15:51
     */
    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback", commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),  //是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"), //请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"),   //时间窗口期
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60"),   //失败率达到多少后熔断

    })
    public String paymentCircuitBreaker(Integer id){
        if(id < 0){
            throw  new RuntimeException("id不能为负数");
        }
        String serialNumber = UUID.randomUUID().toString();
        return Thread.currentThread().getName() + "\t调用成功，流水号：" + serialNumber;
    }
    public String paymentCircuitBreaker_fallback(Integer id){
        return "id不能为负数，请稍后重试。id：" + id;
    }

}
