package com.atguigu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * 2 * @Author: Liu Mingcong
 * 3 * @Date: 2021/2/7 11:12
 * 4
 */
@SpringBootApplication
@EnableHystrixDashboard
public class HystrixDashboardMain9002 {
    public static void main(String[] args) {
        SpringApplication.run(HystrixDashboardMain9002.class,args);
    }
}
