package com.example.spring.boot_security.service;

import com.example.spring.boot_security.model.User;

import java.util.List;

public interface UserService  {


    void addUser (User user);
    void editUser (User user);
    void deleteUser(User user);
    List<User> getAllUsers();
     User getUserById (Long id);
    User findUserByEmail (String email);





}
