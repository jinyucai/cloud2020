package com.cai.springcloud.controller;

import com.cai.springcloud.entities.CommonResult;
import com.cai.springcloud.entities.Payment;
import com.cai.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/consumer")
@Slf4j
public class OrderFeignClientController {

    @Autowired
    private PaymentService paymentService;

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
        return paymentService.getPaymentById(id);
    }

    @RequestMapping(value = "payment/feigntimeout")
    public String testFeignTimeout() {
        String s = paymentService.testFeignTimeout();
        return s;
    }

}
