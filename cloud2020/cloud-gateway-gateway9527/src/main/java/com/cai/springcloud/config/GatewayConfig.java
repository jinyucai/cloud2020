package com.cai.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {

    @Bean
    public RouteLocator customerRouteLocator(RouteLocatorBuilder routeLocatorBuilder) {
        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();
        routes.route("path_route_cai", r -> r.path("/guonei")
                .uri("https://news.baidu.com/guonei"));
        routes.route("path_route_cai", r -> r.path("/tech")
                .uri("https://news.baidu.com/tech"));
        routes.route("path_route_cai", r -> r.path("/game")
                .uri("https://news.baidu.com/game"));
        return routes.build();
    }

}
