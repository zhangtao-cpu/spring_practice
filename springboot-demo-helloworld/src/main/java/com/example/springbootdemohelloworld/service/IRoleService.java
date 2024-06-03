package com.example.springbootdemohelloworld.service;


import com.example.springbootdemohelloworld.entity.Role;
import com.example.springbootdemohelloworld.entity.query.RoleQueryBean;

import java.util.List;

public interface IRoleService {

    List<Role> findList(RoleQueryBean roleQueryBean);

}
