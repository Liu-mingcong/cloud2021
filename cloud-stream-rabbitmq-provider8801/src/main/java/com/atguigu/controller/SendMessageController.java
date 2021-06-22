package com.atguigu.controller;

import com.atguigu.service.IMessageProvider;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 2 * @Author: Liu Mingcong
 * 3 * @Date: 2021/2/8 22:36
 * 4
 */
@RestController
public class SendMessageController {
    @Resource
    private IMessageProvider iMessageProvider;

    @GetMapping("sendMessage")
    public String sendMessage(){
        return iMessageProvider.send();
    }
}
