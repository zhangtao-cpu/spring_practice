package com.example.springbootdemohelloworld.controller;


import com.example.springbootdemohelloworld.entity.Role;
import com.example.springbootdemohelloworld.entity.query.RoleQueryBean;
import com.example.springbootdemohelloworld.entity.response.ResponseResult;
import com.example.springbootdemohelloworld.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author pdai
 */
@RestController
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private IRoleService roleService;

    /**
     * @return user list
     */
    @GetMapping("list")
    public ResponseResult<List<Role>> list(RoleQueryBean roleQueryBean) {
        return ResponseResult.success(roleService.findList(roleQueryBean));
    }
}
