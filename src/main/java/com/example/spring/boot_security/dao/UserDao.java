package com.example.spring.boot_security.dao;

import com.example.spring.boot_security.model.User;

import java.util.List;


public interface UserDao {


    void addUser (User user);
    void editUser (User user);
    void deleteUser(User user);
    List<User> getAllUsers();
     User getUserById (Long id);




     // добавлено мной
     User findUserByEmail (String email);
}
