package cpm.cai.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "nacos-payment-provider")
public interface PaymentService {


    @GetMapping(value = "/payment/port")
    public String getPort();

}
