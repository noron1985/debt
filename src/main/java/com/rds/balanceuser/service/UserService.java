package com.rds.balanceuser.service;

import com.rds.balanceuser.api.dto.UserDto;
import com.rds.balanceuser.dao.UserDao;
import com.rds.balanceuser.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class UserService implements Function<User, UserDto> {

    @Autowired
    private UserDao userDao;

    public UserDto findById(int id){
        User user = userDao.findById(id);
        if (user.getId() != 0){
            return apply(user);
        }
        // TODO custom exception
        else throw new RuntimeException("User not found");
    }

    public List<UserDto> findAll() {
        return userDao.findAll().stream().map(this::apply).collect(Collectors.toList());
    }

    public UserDto findByName(String name) {
        return apply(userDao.findByName(name));
    }

    public UserDto save(User user) {
        return apply(userDao.save(user));
    }

    @Override
    public UserDto apply(User user) {
        return new UserDto(user.getName(), user.getBalances());
    }
}
