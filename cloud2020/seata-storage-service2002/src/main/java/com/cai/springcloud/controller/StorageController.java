package com.cai.springcloud.controller;

import com.cai.springcloud.entities.CommonResult;
import com.cai.springcloud.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/storage")
public class StorageController {

    @Autowired
    private StorageService storageService;

    @PostMapping("/decrease")
    public CommonResult decrease(@RequestParam("productId") Long productId,
                                  @RequestParam("count") Integer count) {
        storageService.decrease(productId,count);
        return new CommonResult(200, "扣减库存成功");
    }

}
