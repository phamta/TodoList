package com.tanvan.todolist.service;

import com.tanvan.todolist.entity.UserEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    List<UserEntity> users = new ArrayList<UserEntity>();

    public UserService(){
        users.add(new UserEntity(1, "tanvan", "123"));
        users.add(new UserEntity(2, "tanvan", "456"));
        users.add(new UserEntity(3, "tanvan", "789"));
    }

    public Optional<UserEntity> authenticateUser(String username, String password) {
        return users.stream()
                .filter(user -> user.getUsername().equals(username) && user.getPassword().equals(password))
                .findFirst();
    }
}
