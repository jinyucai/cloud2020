package com.cai.springcloud.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.cai.springcloud.dao.StorageDao")
public class MyBatisConfig {
}
