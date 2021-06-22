package com.atguigu.lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 2 * @Author: Liu Mingcong
 * 3 * @D0ate: 2021/2/5 1:13
 * 4
 */
@Component
public class MyLB implements LoadBalancer{

    private AtomicInteger atomicInteger = new AtomicInteger(0); //原子性

    //CAS自旋锁
    public final int getAndIncrement(){
        int current;
        int next;
        do {
            current = this.atomicInteger.get();
            next = current >= 2147483647 ? 0 :current + 1;
        }while (!this.atomicInteger.compareAndSet(current,next));
        System.out.println("*******第几次访问,次数:"+next);
        return next;
    }

    @Override
    public ServiceInstance instance(List<ServiceInstance> serviceInstances) {
        int index = getAndIncrement() % serviceInstances.size();
        return serviceInstances.get(index); //返回指定服务器
    }
}
