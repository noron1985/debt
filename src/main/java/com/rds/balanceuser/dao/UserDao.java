package com.rds.balanceuser.dao;

import com.rds.balanceuser.model.User;

import java.util.List;

public interface UserDao {

    User findById(int id);

    List<User> findAll();

    User findByName(String name);

    User save(User user);

//    User delete(int id);



}
