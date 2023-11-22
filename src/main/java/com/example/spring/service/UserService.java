package com.example.spring.service;

import com.example.spring.models.User;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();

    User getUser(int id);

    void saveUser(User user);

    void updateUser(int id, User user);

    void deleteUser(int id);
}
