package com.cai.springcloud.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
@FeignClient(value = "CLOUD-PROVIDER-HYSTRIX-PAYMENT", fallback = PaymentFallbackService.class)
public interface PaymentService {

    @RequestMapping("/payment/timeok/{id}")
    public String paymentInfo_ok(@PathVariable("id") Integer id);

    @RequestMapping("/payment/timeout/{id}")
    public String paymentInfo_timeout(@PathVariable("id") Integer id);

}
