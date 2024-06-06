package com.example.springbootdemohelloworld;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class SpringbootDemoHelloworldApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootDemoHelloworldApplication.class, args);
        System.out.println("项目已经启动了！！！");
    }

    @GetMapping("/list")
    public String list(){
        Integer total = 1;
        return "我是一名优秀的赛力斯员工！！！";
    }

}
