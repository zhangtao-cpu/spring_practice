package com.example.springbootdemohelloworld.service;


import com.example.springbootdemohelloworld.entity.User;
import com.example.springbootdemohelloworld.entity.query.UserQueryBean;

import java.util.List;


/**
 * @author pdai
 */
public interface IUserService {

    List<User> findList(UserQueryBean userQueryBean);

    User findById(Long id);

    int deleteById(Long id);

    int deleteByIds(Long[] ids);

    int update(User user);

    int save(User user);

    int updatePassword(User user);

}
