package com.example.spring.boot_security.dao;


import com.example.spring.boot_security.model.Role;

import java.util.List;

public interface RoleDao {

    Role findRoleByName(String roleName);
    List<Role> findAllRoles();

}
