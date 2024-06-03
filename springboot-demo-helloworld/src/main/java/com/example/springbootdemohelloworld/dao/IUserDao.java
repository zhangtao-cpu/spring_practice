package com.example.springbootdemohelloworld.dao;

import com.example.springbootdemohelloworld.entity.User;
import com.example.springbootdemohelloworld.entity.query.UserQueryBean;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author pdai
 */
@Mapper
public interface IUserDao {

    List<User> findList(UserQueryBean userQueryBean);

    User findById(Long id);

    int deleteById(Long id);

    int deleteByIds(Long[] ids);

    int update(User user);

    int save(User user);

    int updatePassword(User user);
}
