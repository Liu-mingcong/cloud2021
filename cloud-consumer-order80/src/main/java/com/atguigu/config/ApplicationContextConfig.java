package com.atguigu.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ApplicationContextConfig {
    @Bean
   // @LoadBalanced 赋予restTemplate负载均衡的能力  默认轮询负载机制
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
//相当于<bean id="getRestTemplate" class="org.springframework.web.client.RestTemplate"></bean>
