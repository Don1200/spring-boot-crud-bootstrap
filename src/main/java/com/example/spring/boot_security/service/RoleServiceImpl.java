package com.example.spring.boot_security.service;

import com.example.spring.boot_security.dao.RoleDao;
import com.example.spring.boot_security.model.Role;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService{
   private final RoleDao roleDao;

    public RoleServiceImpl(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    @Override
    public Role findRoleByName(String roleName) {
        return roleDao.findRoleByName(roleName);
    }

    @Override
    public List<Role> findAllRoles() {
        return roleDao.findAllRoles();
    }
}
