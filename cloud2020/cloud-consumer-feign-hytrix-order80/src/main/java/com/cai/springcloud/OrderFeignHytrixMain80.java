package com.cai.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
@EnableHystrix  //客户端加的不是@EnableCircuitBreaker
public class OrderFeignHytrixMain80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderFeignHytrixMain80.class);
    }
}
