package com.cai.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class AlibabaProviderPayment9003 {

    public static void main(String[] args) {
        SpringApplication.run(AlibabaProviderPayment9003.class);
    }
}
