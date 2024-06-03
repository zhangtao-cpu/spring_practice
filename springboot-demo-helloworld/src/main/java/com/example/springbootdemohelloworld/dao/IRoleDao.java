package com.example.springbootdemohelloworld.dao;

import com.example.springbootdemohelloworld.entity.Role;
import com.example.springbootdemohelloworld.entity.query.RoleQueryBean;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author pdai
 */
@Mapper
public interface IRoleDao {
    List<Role> findList(RoleQueryBean roleQueryBean);
}
