package com.example.spring.boot_security.service;

import com.example.spring.boot_security.model.Role;

import java.util.List;

public interface RoleService {
    Role findRoleByName(String roleName);
    List<Role> findAllRoles();
}
