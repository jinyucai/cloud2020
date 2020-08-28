package com.cai.springcloudalibaba.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "payment")
public class NacosProviderPaymentController {
    @Value("${server.port}")
    private String serverPort;

    @GetMapping(value = "/getPort/{id}")
    public String getServerPort(@PathVariable("id") String id) {
        return serverPort + "==>" + id;
    }
}
