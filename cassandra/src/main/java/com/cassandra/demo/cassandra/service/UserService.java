package com.cassandra.demo.cassandra.service;

import com.cassandra.demo.cassandra.model.User;
import org.springframework.http.ResponseEntity;

public interface UserService {
    Object addUser(User user);

    Object getAllInfo();

    Object getByName(String name);
}
