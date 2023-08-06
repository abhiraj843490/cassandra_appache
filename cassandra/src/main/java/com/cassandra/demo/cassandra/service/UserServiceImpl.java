package com.cassandra.demo.cassandra.service;

import com.cassandra.demo.cassandra.model.User;
import com.cassandra.demo.cassandra.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepo userRepo;
    @Override
    public Object addUser(User user) {

        return userRepo.save(user);
    }

    @Override
    public Object getAllInfo() {
        return userRepo.findAll();
    }

    @Override
    public Object getByName(String name) {
        return userRepo.findByName(name);
    }
}
