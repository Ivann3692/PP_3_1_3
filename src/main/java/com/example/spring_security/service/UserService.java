package com.example.spring_security.service;

import com.example.spring_security.model.User;

import java.util.List;


public interface UserService {

    List<User> getAllUser();

    void addUser(User user);

    User findUserById(Long id);

    void deleteUserById(Long id);

    User findUserByName(String name);


}
