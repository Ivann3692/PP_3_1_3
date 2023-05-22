package com.example.spring_security.controller;

import com.example.spring_security.model.Role;
import com.example.spring_security.model.User;
import com.example.spring_security.service.RoleService;
import com.example.spring_security.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller()
@RequestMapping("admin")
@AllArgsConstructor
public class AdminController {

    private final UserService userService;
    private final RoleService roleService;

    @GetMapping("")
    public String showAllUser(ModelMap model) {
        List<User> messages = userService.getAllUser();
        model.addAttribute("messages", messages);
        return "adminPanel";
    }

    @GetMapping("/addNewUser")
    public String addNewUser(ModelMap model) {
        model.addAttribute("messages", new User());
        model.addAttribute("roles", roleService.getAllRole());
        return "userPage";
    }

    @PostMapping()
    public String addUser(@ModelAttribute("messages") User user) {
        userService.addUser(user);
        return "redirect:/admin";
    }

    @DeleteMapping("user-delete/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        userService.deleteUserById(id);
        return "redirect:/admin";

    }

    @GetMapping("/user-update/{id}")
    public String updateUser(@PathVariable("id") Long id, ModelMap model) {
        User messages = userService.findUserById(id);
        model.addAttribute("messages", messages);
        List<Role> roles = roleService.getAllRole();
        model.addAttribute("roles", roles);
        return "userPage";
    }
}
