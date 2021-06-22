package com.atguigu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 2 * @Author: Liu Mingcong
 * 3 * @Date: 2021/2/3 23:43
 * 4
 */
@SpringBootApplication
@EnableDiscoveryClient
public class OrderMainZk80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderMainZk80.class,args);
    }
}
