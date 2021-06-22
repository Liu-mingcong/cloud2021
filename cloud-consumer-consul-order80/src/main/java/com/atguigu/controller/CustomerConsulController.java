package com.atguigu.controller;

import com.atguigu.entities.CommonResult;
import com.atguigu.entities.Payment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
public class CustomerConsulController {
    public static final String INVOKE_URL="http:// consul-payment-service";
    @Resource
    private RestTemplate restTemplate;

    @RequestMapping("consumer/consul/{id}")
    public CommonResult<Payment> paymentInfo(@PathVariable("id") Long id){
        return  restTemplate.getForObject(INVOKE_URL + "/payment/" + id, CommonResult.class);
    }

    @GetMapping("payment/consul")
    public String getConsul(){
        return restTemplate.getForObject(INVOKE_URL+"/payment/consul",String.class);
    }
}
// localhost:82/customer/payment/1
