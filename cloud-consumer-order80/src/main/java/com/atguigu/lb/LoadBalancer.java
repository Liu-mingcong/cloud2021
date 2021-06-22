package com.atguigu.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * 2 * @Author: Liu Mingcong
 * 3 * @Date: 2021/2/5 1:11
 * 4 * @Mean: 自制负载轮询算法
 */
public interface LoadBalancer {
    //循环计数器
    ServiceInstance instance(List<ServiceInstance> serviceInstances);
}
