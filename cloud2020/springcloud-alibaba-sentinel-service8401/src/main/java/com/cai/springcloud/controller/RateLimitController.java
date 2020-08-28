package com.cai.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.cai.springcloud.handler.GlobalHndler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RateLimitController {

    @GetMapping("/byResource")
    @SentinelResource(value = "byResource", blockHandler = "resource")
    public String byResource() {
        return "成功";
    }
    @GetMapping("/byResource/byurl")
    @SentinelResource(value = "byurl", blockHandlerClass = GlobalHndler.class, blockHandler = "exceptionHandler")
    public String test() {
        return "成功2";
    }

    public String resource(BlockException e) {
        return e.getClass().getName();
    }

}
