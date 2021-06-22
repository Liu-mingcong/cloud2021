package com.atguigu.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 2 * @Author: Liu Mingcong
 * 3 * @Date: 2021/2/8 16:22
 * 4
 */
@RestController
public class ConfigClientController {

    @Value("${server.port}")
    private String port;

    @Value("${config.info}")
    private String configInfo;

    @GetMapping("configInfo")
    public String configInfo(){
        return configInfo;
    }
}
