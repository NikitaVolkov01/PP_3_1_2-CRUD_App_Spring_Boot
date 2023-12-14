package com.example.demo.services;

import com.example.demo.models.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();

    User getUser(int id);

    void saveUser(User user);

    void deleteUser(int id);
}

