package com.atguigu;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 2 * @Author: Liu Mingcong
 * 3 * @Date: 2021/2/3 23:13
 * 4
 */
@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.atguigu.dao")
public class PaymentMain8004 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentMain8004.class,args);
    }
}
