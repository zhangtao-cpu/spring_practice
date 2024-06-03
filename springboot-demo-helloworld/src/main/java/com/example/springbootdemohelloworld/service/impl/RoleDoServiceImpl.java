package com.example.springbootdemohelloworld.service.impl;

import com.example.springbootdemohelloworld.dao.IRoleDao;
import com.example.springbootdemohelloworld.entity.Role;
import com.example.springbootdemohelloworld.entity.query.RoleQueryBean;
import com.example.springbootdemohelloworld.service.IRoleService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleDoServiceImpl implements IRoleService {

    /**
     * roleDao.
     */
    private final IRoleDao roleDao;

    /**
     * init.
     *
     * @param roleDao2 role dao
     */
    public RoleDoServiceImpl(final IRoleDao roleDao2) {
        this.roleDao = roleDao2;
    }

    @Override
    public List<Role> findList(RoleQueryBean roleQueryBean) {
        return roleDao.findList(roleQueryBean);
    }
}
