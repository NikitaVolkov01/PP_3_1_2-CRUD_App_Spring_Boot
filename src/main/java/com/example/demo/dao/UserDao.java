package com.example.demo.dao;


import com.example.demo.models.User;

import java.util.List;

public interface UserDao {

    List<User> getAllUsers();

    User getUser(int id);

    void saveUser(User user);

    void deleteUser(int id);
}
