package com.example.spring.boot_security.dao;

import com.example.spring.boot_security.model.Role;
import com.example.spring.boot_security.model.User;
import org.springframework.stereotype.Repository;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class RoleDaoImpl implements RoleDao {

    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public Role findRoleByName(String roleName) {
        return entityManager.createQuery("SELECT u FROM Role u WHERE u.roleName = :roleName", Role.class)
                .setParameter("roleName", roleName).getSingleResult();
    }

    @Override
    public List<Role> findAllRoles() {
        return entityManager.createQuery("from Role", Role.class)
                .getResultList();
    }

}
