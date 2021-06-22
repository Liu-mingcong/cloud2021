package com.atguigu;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 2 * @Author: Liu Mingcong
 * 3 * @Date: 2021/2/4 0:15
 * 4
 */
@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.atguigu.dao")
public class PaymentMain8006 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentMain8006.class,args);
    }
}
