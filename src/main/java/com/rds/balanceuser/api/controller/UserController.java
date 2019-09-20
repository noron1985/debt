package com.rds.balanceuser.api.controller;

import com.rds.balanceuser.api.dto.UserDto;
import com.rds.balanceuser.model.User;
import com.rds.balanceuser.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


// faire un controller TimeLeaf qui vont contacter tous les deux userservice

@RestController
public class UserController  {

    @Autowired
    private UserService userService;


    @GetMapping("/api/users")
    public List<UserDto> findAll(){
        return userService.findAll();
    }

    @GetMapping("/api/user/{id}")
    public UserDto findById(@PathVariable int id){
        return userService.findById(id);
    }

    @PostMapping("/api/user")
    public UserDto save(@RequestBody User user) {
        return userService.save(user);
    }





}
