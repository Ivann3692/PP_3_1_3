package com.example.spring_security.controller;

import com.example.spring_security.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.spring_security.service.UserService;

import java.security.Principal;

@Controller
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String getUser(Model model, Principal principal) {
        User messages = userService.findUserByName(principal.getName());
        model.addAttribute("messages", messages);
        return "login";
    }
}
