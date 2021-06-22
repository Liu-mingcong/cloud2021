package com.atguigu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * 2 * @Author: Liu Mingcong
 * 3 * @Date: 2021/2/2 18:25
 * 4
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)// exclude ：启动时不启用 DataSource的自动配置检查
@EnableEurekaServer //开启Eureka服务
public class EurekaMain7001 {
    public static void main(String[] args) {
        SpringApplication.run(EurekaMain7001.class,args);
    }
}
