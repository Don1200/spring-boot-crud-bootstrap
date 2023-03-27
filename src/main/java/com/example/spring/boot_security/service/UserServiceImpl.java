package com.example.spring.boot_security.service;

import com.example.spring.boot_security.dao.UserDao;
import com.example.spring.boot_security.model.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Service
public class UserServiceImpl implements UserService  {
    private final UserDao userDao;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserDao userDao, PasswordEncoder passwordEncoder) {
        this.userDao = userDao;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    @Transactional
    public void addUser(User user) {
        String newPass = passwordEncoder.encode(user.getPassword());
        user.setPassword(newPass);
        userDao.addUser(user);
    }
    @Override
    @Transactional
    public void editUser(User user) {
        String newPass = passwordEncoder.encode(user.getPassword());
        user.setPassword(newPass);
        userDao.editUser(user);
    }
    @Override
    @Transactional
    public void deleteUser(User user) {
        userDao.deleteUser(user);
    }
    @Transactional
    @Override
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }
    @Transactional
    @Override
    public User getUserById(Long id) {
        return userDao.getUserById(id);
    }

    @Override
    public User findUserByEmail(String email) {
        return userDao.findUserByEmail(email);
    }


}

