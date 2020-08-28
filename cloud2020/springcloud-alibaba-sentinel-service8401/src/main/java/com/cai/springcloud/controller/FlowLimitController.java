package com.cai.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;
import java.util.logging.Handler;

@RestController
public class FlowLimitController {

    @GetMapping(value = "/testA")
    public String testA() {
        return "======testA";
    }

    @GetMapping(value = "/testB")
    public String testB() {
        try {
            Thread.sleep(800);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "======testB";
    }

    @GetMapping(value = "/testD")
    public String testD() {
        int age = 10/0;
        return "======testD";
    }

    @GetMapping(value = "/hotKey")
    @SentinelResource(value = "hotKey", blockHandler = "err_handler")
    public String testHotkey(@RequestParam(value = "a", required = false) String a) {
        return "===hotKey";
    }

    public String err_handler(String a, BlockException ex) {
        return "error==o(╥﹏╥)o";
    }

}
