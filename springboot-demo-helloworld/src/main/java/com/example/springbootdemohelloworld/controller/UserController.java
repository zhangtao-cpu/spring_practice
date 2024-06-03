package com.example.springbootdemohelloworld.controller;


import com.example.springbootdemohelloworld.entity.User;
import com.example.springbootdemohelloworld.entity.query.UserQueryBean;
import com.example.springbootdemohelloworld.entity.response.ResponseResult;
import com.example.springbootdemohelloworld.service.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @Description
 * @Author zhangtao
 * @Date 2024/1/19 16:14
 */

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @RequestMapping("/getUser")
    public String getUser(){
        logger.info("getUser response!!!");
        return "zhangtao";
    }


    @PostMapping("/add")
    public ResponseResult<User> add(User user) {
        if (user.getId()==null) {
            user.setCreateTime(LocalDateTime.now());
            user.setUpdateTime(LocalDateTime.now());
            userService.save(user);
        } else {
            user.setUpdateTime(LocalDateTime.now());
            userService.update(user);
        }
        return ResponseResult.success(userService.findById(user.getId()));
    }

    @GetMapping("/edit/{userId}")
    public ResponseResult<User> edit(@PathVariable("userId") Long userId) {
        return ResponseResult.success(userService.findById(userId));
    }

    @GetMapping("/list")
    public ResponseResult<List<User>> list(UserQueryBean userQueryBean) {
        logger.info("这是调用user的全部信息");
        return ResponseResult.success(userService.findList(userQueryBean));
    }

}
