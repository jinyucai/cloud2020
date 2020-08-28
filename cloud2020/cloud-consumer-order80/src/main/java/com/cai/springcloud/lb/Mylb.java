package com.cai.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Component
public class Mylb implements LoadBalancer {

    private AtomicInteger atomicInteger = new AtomicInteger(0);

    private int getAndIncrement() {
        int current = 0;
        int next = 0;
        for(;;) {
            current = atomicInteger.get();
            next = current >= Integer.MAX_VALUE?0:current + 1;
            if(atomicInteger.compareAndSet(current, next)){
                System.out.println("访问了第" + next + "次");
                return next;
            }
        }
    }

    @Override
    public ServiceInstance instance(List<ServiceInstance> serviceInstances) {
        if(serviceInstances.size() == 0)return null;
        int index = this.getAndIncrement()%serviceInstances.size();
        ServiceInstance serviceInstance = serviceInstances.get(index);
        return serviceInstance;
    }
}
