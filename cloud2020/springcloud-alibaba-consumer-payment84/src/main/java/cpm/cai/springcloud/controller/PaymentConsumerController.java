package cpm.cai.springcloud.controller;

import cpm.cai.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping(value = "/consumer")
public class PaymentConsumerController {


    private static final String PROVIDER_PAYMENT= "nacos-payment-provider";

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping(value = "/port")
    public String getPort() {
        String s = restTemplate.getForObject("http://" + PROVIDER_PAYMENT + "/payment/port", String.class);
        return s;
    }

    @Autowired
    private PaymentService paymentService;

    @GetMapping(value = "/port2")
    public String getPort2() {
        return paymentService.getPort();
    }

}
