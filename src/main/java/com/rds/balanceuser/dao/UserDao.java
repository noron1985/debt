package com.rds.balanceuser.dao;

import com.rds.balanceuser.model.User;

import java.util.List;

public interface UserDao {

    User findById(int id);

    User findByName(String name);

    List<User> findAll();

    User save(User user);

//    User delete(int id);



}
