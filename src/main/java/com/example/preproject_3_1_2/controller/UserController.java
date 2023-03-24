package com.example.preproject_3_1_2.controller;

import com.example.preproject_3_1_2.model.User;
import com.example.preproject_3_1_2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping(value = "/")
    public String getUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "index";
    }

    @GetMapping(value = "/add")
    public String addForm(User user) {
        return "add";
    }

    @PostMapping(value = "/add")
    public String addUsers(User user) {
        userService.addUser(user);
        return "redirect:/";
    }

    @GetMapping(value = "/delete/{id}")
    public String deleteUsers(@PathVariable("id") Long id) {
        userService.deleteUser(id);
        return "redirect:/";
    }

    @GetMapping(value = "/edit/{id}")
    public String editForm(@PathVariable("id") Long id, Model model) {
        model.addAttribute("user", userService.getUserById(id));
        return "edit";
    }

    @PostMapping(value = "/edit/{id}")
    public String editUsers(User user, @PathVariable("id") Long id) {
        userService.updateUser(user);
        return "redirect:/";
    }
}
