package com.atguigu.service.impl;

import com.atguigu.service.IMessageProvider;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * 2 * @Author: Liu Mingcong
 * 3 * @Date: 2021/2/8 22:29
 * 4
 */
@EnableBinding(Source.class)    //定义消息推送管道
public class IMessageProviderImpl implements IMessageProvider {

    @Resource
    private MessageChannel output;  //消息发送管道

    @Override
    public String send() {
        String serial = UUID.randomUUID().toString();
        output.send(MessageBuilder.withPayload(serial).build());
        System.out.println("*****serial" + serial);
        return null;
    }
}
