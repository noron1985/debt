package com.rds.balanceuser.api.controller;

import com.rds.balanceuser.api.dto.UserDto;
import com.rds.balanceuser.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController  {

    @Autowired
    private UserService userService;


    @GetMapping("/api/users")
    public List<UserDto> findAll(){
        //TODO create dto users find all
        return null;
    }

    @GetMapping("/api/user/{id}")
    public UserDto findById(@PathVariable int id){
        return userService.findById(id);
    }





}
