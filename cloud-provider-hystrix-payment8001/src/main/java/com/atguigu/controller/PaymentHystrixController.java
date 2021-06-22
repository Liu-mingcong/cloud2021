package com.atguigu.controller;

import com.atguigu.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 2 * @Author: Liu Mingcong
 * 3 * @Date: 2021/2/6 22:19
 * 4
 */
@RestController
@Slf4j
public class PaymentHystrixController {

    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String port;

    @GetMapping("payment/ok/{id}")
    public String paymentInfo_ok(@PathVariable("id")Integer id){
        return paymentService.PaymentInfo_OK(id);
    }

    @GetMapping("payment/timeout/{id}")
    public String paymentInfo_Timeout(@PathVariable("id")Integer id){
        return paymentService.PaymentInfo_Timeout(id);
    }
}
