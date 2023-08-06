package com.cassandra.demo.cassandra.controller;

import com.cassandra.demo.cassandra.model.User;
import com.cassandra.demo.cassandra.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    @Autowired
    private UserService service;
    @PostMapping("/save")
    public Object addUser(@RequestBody User user){
        return service.addUser(user);
    }
    @GetMapping("/")
    public Object getAllInfo(){
        return service.getAllInfo();
    }
    @GetMapping("/get/{name}")
    public Object getByName(@PathVariable String name){
        return service.getByName(name);
    }

}
