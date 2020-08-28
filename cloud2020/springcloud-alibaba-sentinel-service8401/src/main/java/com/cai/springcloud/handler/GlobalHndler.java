package com.cai.springcloud.handler;

import com.alibaba.csp.sentinel.slots.block.BlockException;

public class GlobalHndler {

    public static String exceptionHandler(BlockException e) {
        return "全局熔断处理";
    }

}
