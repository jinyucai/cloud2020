package com.cai.springcloud.service.impl;

import com.cai.springcloud.dao.OrderDao;
import com.cai.springcloud.domain.Order;
import com.cai.springcloud.service.AccountService;
import com.cai.springcloud.service.OrderService;
import com.cai.springcloud.service.StorageService;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDao orderDao;

    @Autowired
    private StorageService storageService;

    @Autowired
    private AccountService accountService;

    @Override
    @GlobalTransactional
    public void create(Order order) {
        //加订单
        orderDao.create(order);
        //减库存
        storageService.decrease(order.getProductId(), order.getCount());
        //账户扣钱
        accountService.decrease(order.getUserId(), order.getMoney());
        this.update(order.getUserId(), 0);
    }

    @Override
    public void update(Long userId, Integer status) {
        orderDao.update(userId, status);
    }
}
