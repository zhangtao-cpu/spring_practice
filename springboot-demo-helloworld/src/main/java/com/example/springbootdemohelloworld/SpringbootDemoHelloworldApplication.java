package com.example.springbootdemohelloworld;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@SpringBootApplication
public class SpringbootDemoHelloworldApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootDemoHelloworldApplication.class, args);
        System.out.println("项目已经启动了！！！");
    }

    @GetMapping("/list")
    public void list(){
        Integer total = 1;
        log.info("/admin/list,count number{}",total);
        log.info("/admin/list,test log line");
    }

}
