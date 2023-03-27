package com.example.spring.boot_security.controller;


import com.example.spring.boot_security.model.Role;
import com.example.spring.boot_security.model.User;
import com.example.spring.boot_security.service.RoleService;
import com.example.spring.boot_security.service.UserService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
@RequestMapping(value = "/admin")
@Controller
public class AdminController {
    private final UserService userService;
    private final RoleService roleService;


    public AdminController(UserService userService, RoleService roleService ) {
        this.userService = userService;
        this.roleService = roleService;

    }

    @GetMapping(value = "/users")
    public String getAllUsers(Model model, @AuthenticationPrincipal UserDetails userDetails) {
        User user = userService.findUserByEmail(userDetails.getUsername());
        List<User> users = userService.getAllUsers();
        List <Role> listRoles = roleService.findAllRoles();
        model.addAttribute("listRoles",listRoles);
        model.addAttribute("roles",user.getRolesByUser());
        model.addAttribute("users", users);
        model.addAttribute("user",user);
        User newUser = new User();
        model.addAttribute("newUser",newUser);
        return "users";
    }

    @PostMapping(value = "/addUser")
    public String NewUser(Model model, @ModelAttribute("user") User user,
                                        @RequestParam(value = "role", required = false) String[] role) {
        Set<Role> rolesSet = new HashSet<>();
        for (String s : role) {
            rolesSet.add(roleService.findRoleByName(s));
        }
        user.setRoles(rolesSet);
        userService.addUser(user);
        return "redirect:/admin/users";
    }

    @GetMapping("/{id}")
    public String getUser(@PathVariable("id") Long id, Model model) {
        model.addAttribute("user", userService.getUserById(id));
        model.addAttribute("roles", roleService.findAllRoles());
        return "edit";
    }

    @PutMapping("/edit")
    public String editUser(@ModelAttribute("user") User user,
                           @RequestParam(value = "role", required = false) String[] role) {
        Set<Role> rolesSet = new HashSet<>();
        for (String s : role) {
            rolesSet.add(roleService.findRoleByName(s));
        }
        user.setRoles(rolesSet);
        userService.editUser(user);
        return "redirect:/admin/users";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        userService.deleteUser(userService.getUserById(id));
        return "redirect:/admin/users";
    }


}
