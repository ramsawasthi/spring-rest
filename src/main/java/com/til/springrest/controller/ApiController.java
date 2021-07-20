package com.til.springrest.controller;

import com.til.springrest.beans.UserBean;
import com.til.springrest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ApiController {
    @Autowired
    private UserService userService;

    @GetMapping(path = "/hello/{name}")
    public String sayHello(@PathVariable String name) {
            return  String.format("Hello %s", name);
    }

    @GetMapping(path = "/get-user/{id}")
    public UserBean getUserById(@PathVariable Integer id) {
        return userService.findOne(id);
    }

    @GetMapping(path= "/get-all")
    public List<UserBean> getAllUsers() {
        return userService.findAll();
    }

    @PostMapping(path="save-user")
    public UserBean addUser(@RequestBody UserBean userBean){
        return userService.add(userBean);
    }


}


