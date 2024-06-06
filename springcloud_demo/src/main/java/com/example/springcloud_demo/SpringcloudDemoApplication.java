package com.example.springcloud_demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


//新建了SpringBoot工程，然后运行了一下就退出了?
//原因：没有引入任何使用场景，比如：web场景，netty长链接场景，所以没有任何线程池创建出来，所以就退出了，只有守护线程
@SpringBootApplication
public class SpringcloudDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringcloudDemoApplication.class, args);
        System.out.println("SpringcloudDemoApplication启动了！！！");
    }

}
