package com.cai.springcloud.controller;

import com.cai.springcloud.service.PaymentService;
import com.cai.springcloud.entities.CommonResult;
import com.cai.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

@RestController
@Slf4j
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    @Autowired
    private PaymentService paymentService;
    @Autowired
    private DiscoveryClient discoveryClient;

    /*
    添加
     */
    @PostMapping(value = "/payment/create")
    public CommonResult<Integer> createPayment(@RequestBody Payment payment){
        int result = paymentService.createPayment(payment);
        log.info("插入结果 " + result);
        if(result > 0) {
            return new CommonResult<Integer>(200, "数据库插入成功,serverPort: "+serverPort, result);
        }else {
            return new CommonResult<Integer>(444, "数据库插入失败,serverPort: "+serverPort);
        }
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){
        Payment payment = paymentService.getPaymentById(id);
        if(payment != null) {
            return new CommonResult<Payment>(200, "查询成功,serverPort: "+serverPort, payment);
        }else {
            return new CommonResult<Payment>(444, "没有对应记录,serverPort: "+serverPort);
        }
    }


    @GetMapping(value = "/payment/discovery")
    public Object discovery() {
        List<String> services = discoveryClient.getServices();
        for (String service : services) {
            log.info("******service: " + service);
        }
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PROVIDER-SERVICE");
        for (ServiceInstance instance : instances) {
            log.info(instance.getServiceId() + "\t" + instance.getHost() +
                    "\t" + instance.getInstanceId() + "\t" + instance.getPort() + "\t" + instance.getUri());
        }
        return this.discoveryClient;
    }

    @GetMapping(value = "/payment/mylb")
    public String testMylb() {
        return serverPort;
    }

    @RequestMapping(value = "payment/feigntimeout")
    public String testFeignTimeout() {
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return serverPort;
    }

}
