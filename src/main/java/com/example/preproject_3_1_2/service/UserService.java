package com.example.preproject_3_1_2.service;

import com.example.preproject_3_1_2.model.User;

import java.util.List;

public interface UserService {
    void addUser(User user);
    void updateUser(User user);
    void deleteUser(Long id);
    List<User> getAllUsers();
    User getUserById(Long id);

}
