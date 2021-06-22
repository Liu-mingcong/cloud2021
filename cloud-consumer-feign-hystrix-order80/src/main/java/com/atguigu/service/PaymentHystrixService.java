package com.atguigu.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * 2 * @Author: Liu Mingcong
 * 3 * @Date: 2021/2/6 22:45
 * 4
 */
@Component
@FeignClient(value = "cloud-payment-hystrix-service")
public interface PaymentHystrixService {
    @GetMapping("payment/ok/{id}")
    String paymentInfo_ok(@PathVariable("id")Integer id);

    @GetMapping("payment/timeout/{id}")
    String paymentInfo_Timeout(@PathVariable("id")Integer id);
}
