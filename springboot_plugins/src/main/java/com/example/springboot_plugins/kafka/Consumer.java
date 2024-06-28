package com.example.springboot_plugins.kafka;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @Description
 * @Author zhangtao
 * @Date 2024/6/13 16:24
 */
@Slf4j
@Component
public class Consumer {
    @Resource
    private KafkaTemplate<String,String> kafkaTemplate;

    @KafkaListener(topics = {"kafkamsg01","test"},groupId = "123")
    public void consume(String message){
        System.out.println("接收到消息："+message);
    }

}
