package com.cai.springcloud.service;

import org.springframework.stereotype.Component;

@Component
public class PaymentFallbackService implements PaymentService {

    @Override
    public String paymentInfo_ok(Integer id) {
        return "paymentInfo_ok error";
    }

    @Override
    public String paymentInfo_timeout(Integer id) {
        return "paymentInfo_timeout error";
        }
        }
