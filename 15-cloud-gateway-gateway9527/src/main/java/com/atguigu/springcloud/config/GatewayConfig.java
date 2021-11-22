package com.atguigu.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description: 路由转发的 java代码 配置模式（效果同yml配置模式）。
 *                  实现：通过 localhost:9527 访问到 B站番剧 网址(www.bilibili.com/anime/)
 * @Author 胡菜鸡
 * @Create 2021-11-22-17:39
 */
@Configuration
public class GatewayConfig {

    @Bean
    public RouteLocator customerRouteLocate(RouteLocatorBuilder routeLocatorBuilder){
        //相当于yml配置文件中的routes
        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();
        routes.route("path_route_atguigu1",
                r -> r.path("/guonei")   //访问 9527 的此地址后会映射到下面的地址中
                        .uri("http://news.baidu.com/guonei")).build();    //路由ID
        routes.route("path_route_atguigu1",
                r -> r.path("/guoji")   //访问 9527 的此地址后会映射到下面的地址中
                        .uri("http://news.baidu.com/guoji")).build();    //路由ID
        return routes.build();
    }

}
