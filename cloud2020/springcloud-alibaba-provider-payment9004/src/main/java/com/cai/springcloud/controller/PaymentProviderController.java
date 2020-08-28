package com.cai.springcloud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/payment")
public class PaymentProviderController {

    @GetMapping(value = "/port")
    public String getPort() {
        return "9004";
    }

}
