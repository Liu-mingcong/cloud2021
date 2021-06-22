package com.atguigu.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * 2 * @Author: Liu Mingcong
 * 3 * @Date: 2021/2/6 22:13
 * 4
 */
@Service
public class PaymentService {

    public String PaymentInfo_OK(Integer id){
        return "线程池:   "+Thread.currentThread().getName()+"  paymentInfo_OF,id:   "+"\t"+id;
    }

    public String PaymentInfo_Timeout(Integer id){
        //int i = 10 / 0 ;
        int time = 3;
        try {
            TimeUnit.SECONDS.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池:      "+Thread.currentThread().getName()+"   paymentInfo_Timeout,id:   "+id+"        延迟"+time+"秒";
    }

    //服务熔断
    @HystrixCommand(fallbackMethod = "timeoutHandler", commandProperties = {
            @HystrixProperty(name="circuitBreaker.enabled", value="true"),  // 是否开启断路器
            @HystrixProperty(name="circuitBreaker.requestVolumeThreshold", value="10"),  //请求次数
            @HystrixProperty(name="circuitBreaker.sleepWindowInMilliseconds", value="10000"), // 时间窗口期
            @HystrixProperty(name="circuitBreaker.errorThresholdPercentage", value="60"),  // 失败率达到多少后跳闸
            //整体意思：10秒内 10次请求，有6次失败，就跳闸
    })
    public String paymentCircuitBreaker(Integer id){
        //模拟发生异常
        if(id < 0){
            throw new RuntimeException("*****id，不能为负数");
        }
        String serialNumber = IdUtil.simpleUUID();
        return Thread.currentThread().getName() + "\t" + "调用成功，流水号：" + serialNumber;
    }

    public String timeoutHandler(Integer id){
        return "id不能为负数，请重试......";
    }
}
