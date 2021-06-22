package com.atguigu.service;

import com.atguigu.entities.CommonResult;
import com.atguigu.entities.Payment;
import org.springframework.stereotype.Service;

@Service
public class PaymentFallbackServiceImpl implements PaymentService {
    @Override
    public CommonResult<Payment> PaymentSQL(Long id) {
        return new CommonResult<>(444444444, "服务降级返回，----PaymentFallbackServiceImpl", new Payment(id, "errorSerial"));
    }
}