package com.tanvan.todolist.service;

import com.tanvan.todolist.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    List<User> users = new ArrayList<User>();

    public UserService(){
        users.add(new User(1, "tanvan", "123"));
        users.add(new User(2, "tanvan", "456"));
        users.add(new User(3, "tanvan", "789"));
    }

    public Optional<User> authenticateUser(String username, String password) {
        return users.stream()
                .filter(user -> user.getUsername().equals(username) && user.getPassword().equals(password))
                .findFirst();
    }
}
