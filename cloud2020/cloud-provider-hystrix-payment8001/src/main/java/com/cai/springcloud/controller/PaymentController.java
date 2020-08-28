package com.cai.springcloud.controller;

import com.cai.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payment")
@Slf4j
public class PaymentController {

    @Autowired
    private PaymentService paymentService;
    @Value("${server.port}")
    private String serverPort;

    @RequestMapping("/timeok/{id}")
    public String paymentInfo_ok(@PathVariable("id") Integer id) {
        String s = paymentService.paymentInfo_ok(id);
        return s;
    }

    @RequestMapping("/timeout/{id}")
    public String paymentInfo_timeout(@PathVariable("id") Integer id) {
        String s = paymentService.paymentInfo_timeout(id);
        return s;
    }


    @RequestMapping("/circuitBreaker/{id}")
        public String paymentCircuitBreaker(@PathVariable("id") Integer id) {
            String s = paymentService.paymentCircuitBreaker(id);
            return s;
    }

}
