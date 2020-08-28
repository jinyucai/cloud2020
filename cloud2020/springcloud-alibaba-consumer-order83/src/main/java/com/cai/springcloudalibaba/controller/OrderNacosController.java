package com.cai.springcloudalibaba.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping(value = "/consumer")
public class OrderNacosController {

    @Value("${service-uri.nacos-user-service}")
    private String service_uri;
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping(value = "/paymentInfo/{id}")
    public String paymentInfo(@PathVariable("id") String id) {
        ResponseEntity<String> entity = restTemplate.getForEntity(service_uri + "/payment/getPort/" + id, String.class);
        if(entity != null) {
            return entity.getBody();
        }
        return null;
    }

}
