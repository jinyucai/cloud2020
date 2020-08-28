package com.cai.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class) //屏蔽springboot自带的数据源
@EnableDiscoveryClient
@EnableFeignClients
public class OrderServiceMain2001 {

    public static void main(String[] args) {
        SpringApplication.run(OrderServiceMain2001.class);
    }

}
