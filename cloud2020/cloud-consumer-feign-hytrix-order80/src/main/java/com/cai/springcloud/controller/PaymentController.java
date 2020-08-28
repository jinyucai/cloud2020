package com.cai.springcloud.controller;

import com.cai.springcloud.service.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/consumer")
@Slf4j
@DefaultProperties(defaultFallback = "global_handler")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @RequestMapping("/timeok/{id}")
    public String paymentInfo_ok(@PathVariable("id") Integer id) {
        return paymentService.paymentInfo_ok(id);
    }

    //客户端的服务降级
//    @HystrixCommand(fallbackMethod = "timeout_handler", commandProperties = {
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1500")
//    })
    @HystrixCommand
    @RequestMapping("/timeout/{id}")
    public String paymentInfo_timeout(@PathVariable("id") Integer id) {
        return paymentService.paymentInfo_timeout(id);
    }

    /**
     * 错误解决方案
     * @param id
     * @return
     */
    public String timeout_handler(Integer id) {
        return "线程池" + Thread.currentThread().getName() + " 支付繁忙请稍后再试 id: " + id + "o(╥﹏╥)o";
    }

    /**
     * 全局的服务熔断
     * @return
     */
    public String global_handler() {
        return "GLOBAL" + "线程池" + Thread.currentThread().getName() +  "o(╥﹏╥)o";
    }

}
