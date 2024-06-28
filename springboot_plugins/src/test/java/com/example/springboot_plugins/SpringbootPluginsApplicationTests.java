package com.example.springboot_plugins;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@SpringBootTest
class SpringbootPluginsApplicationTests {

    @Resource
    private KafkaTemplate<String,String> kafkaTemplate;

    @Test
    void contextLoads() {

    }

    @Test
    public void kafkaSendTest(){
        kafkaTemplate.send("kafkamsg01","hello kafka");
    }
}
