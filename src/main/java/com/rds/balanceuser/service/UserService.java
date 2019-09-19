package com.rds.balanceuser.service;


import com.rds.balanceuser.api.dto.UserDto;
import com.rds.balanceuser.dao.DebtDao;
import com.rds.balanceuser.dao.UserDao;
import com.rds.balanceuser.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Function;

@Service
public class UserService implements Function<User, UserDto> {

    @Autowired
    private UserDao userDao;

    @Autowired
    private DebtDao debtDao;


    public UserDto findById(int id){
        User user = userDao.findById(id);
        if (user.getId() != 0){
            return apply(user);
        }
        // TODO custom exception
        else throw new RuntimeException("User not found");

    }

    public List<User> findAll(){
        return userDao.findAll();
    }


    @Override
    public UserDto apply(User user) {
        return new UserDto(user.getName(),user.getDebts());
    }
}
