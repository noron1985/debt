package com.rds.balanceuser.dao.impl;

import com.rds.balanceuser.dao.UserDao;
import com.rds.balanceuser.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    private List<User> users;

    @Override
    public User findById(int id) {
        return users.stream().filter(user -> user.getId()==id).findFirst().orElse(null);
    }

    @Override
    public List<User> findAll() {
        return users;
    }

    @Override
    public User findByName(String name) {
        return users.stream().filter(user -> user.getName().equals(name)).findFirst().orElse(null);
    }

    @Override
    public User delete(int id) {
        User userToDelete = findById(id);
        if (userToDelete != null){
            users.remove(userToDelete);
        }
        return findById(userToDelete.getId());
    }
}
