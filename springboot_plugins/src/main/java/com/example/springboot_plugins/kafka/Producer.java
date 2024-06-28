package com.example.springboot_plugins.kafka;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.core.KafkaTemplate;

import javax.annotation.Resource;

/**
 * @Description
 * @Author zhangtao
 * @Date 2024/6/13 16:24
 */
@Slf4j
@SpringBootTest
public class Producer {
    @Resource
    private KafkaTemplate<String,String> kafkaTemplate;

    @Test
    public void kafkaSendTest(){
        kafkaTemplate.send("kafkamsg01","hello kafka");
        log.info("test启动了！！！");
    }
}
