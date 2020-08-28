package com.cai.springcloud.service;

import com.cai.springcloud.domain.Order;

public interface OrderService {

    void create(Order order);

    void update(Long userId, Integer status);

}
