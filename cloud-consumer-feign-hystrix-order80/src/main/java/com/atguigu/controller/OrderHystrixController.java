package com.atguigu.controller;

import com.atguigu.service.PaymentHystrixService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 2 * @Author: Liu Mingcong
 * 3 * @Date: 2021/2/6 22:47
 * 4
 */
@RestController
@Slf4j
public class OrderHystrixController {
    @Resource
    private PaymentHystrixService paymentHystrixService;

    @GetMapping("payment/ok/{id}")
    public String paymentInfo_ok(@PathVariable("id")Integer id){
        return paymentHystrixService.paymentInfo_ok(id);
    }

    @GetMapping("payment/timeout/{id}")
    public String paymentInfo_Timeout(@PathVariable("id")Integer id){
        return paymentHystrixService.paymentInfo_Timeout(id);
    }
}
