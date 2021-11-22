package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * 微服务监控程序 Hystrix Dashboard
 *      启动完成后打开：http://localhost:9001/hystrix，在输入框中输入需要监控的地址即可
 * @author 胡菜鸡
 * @date 2021/11/22 16:33
 */
@SpringBootApplication
@EnableHystrixDashboard
public class HystrixDashboardMain9001 {

    public static void main(String[] args) {
        SpringApplication.run(HystrixDashboardMain9001.class, args);
    }

}
