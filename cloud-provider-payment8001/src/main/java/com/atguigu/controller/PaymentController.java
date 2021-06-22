package com.atguigu.controller;

import com.atguigu.entities.CommonResult;
import com.atguigu.entities.Payment;
import com.atguigu.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

@RestController
@Slf4j
public class PaymentController {
    @Resource
    private PaymentService paymentService;

    @Resource
    private DiscoveryClient discoveryClient;    //服务发现

    @Value("${server.port}")
    private String port;

    @PostMapping("payment/create")
    public CommonResult create(Payment payment){
        int i = paymentService.create(payment);
        log.info("*******插入结果"+i);
        if(i > 0){
            return new CommonResult(200,"插入成功,为您服务的是 "+ port,i);
        }
        return new CommonResult(444,"插入失败",null);
    }

    @GetMapping("payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id){
        Payment payment = paymentService.getPaymentById(id);
        log.info("*********查询结果"+payment);
        if(payment != null){
            return new CommonResult(200,"查询成功,为您服务的是 " + port,payment);
        }
        return new CommonResult(444,"查询失败");
    }

    @GetMapping("payment/discovery")
    public Object discovery(){
        List<String> elements = discoveryClient.getServices();
       //elements.stream().forEach(System.out::println);
        elements.forEach((element) ->System.out.print(element+";;"));

        List<ServiceInstance> instances = discoveryClient.getInstances("cloud-payment-service");
        instances.forEach((instance) ->System.out.println(instance.getServiceId()+";"+instance.getHost()+";"+instance.getPort()+";"+instance.getUri()));

        return discoveryClient;
    }

    @GetMapping("payment/lb")
    public String getPaymentLB(){
        return port;
    }

    @GetMapping("payment/feign/timeout")
    public String feignTimeout() throws InterruptedException {
        TimeUnit.SECONDS.sleep(3);
        return port;
    }

    @GetMapping("/payment/zipkin")
    public String paymentZipkin() {
        return "hi,I am payment_zipkin server fall back, welcome to";
    }
}
