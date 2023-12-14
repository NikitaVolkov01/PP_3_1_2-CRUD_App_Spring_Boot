package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import com.example.demo.models.User;
import com.example.demo.services.UserService;

import javax.validation.Valid;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    String redirect = "redirect:/users";
    String usersInfo = "users/userInfo";

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String allUsers(Model model) {
        model.addAttribute("allUsers", userService.getAllUsers());
        return "users/userIndex";
    }

    @GetMapping(value = "/new")
    public String newUser(@ModelAttribute("newUser") User user) {
        return usersInfo;
    }

    @PostMapping
    public String createUser(@ModelAttribute("newUser") @Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return usersInfo;
        }
        userService.saveUser(user);
        return redirect;
    }

    @GetMapping(value = "/updateUser")
    public String updateUser(Model model, @RequestParam("userId") int id) {
        User user = userService.getUser(id);
        model.addAttribute("newUser", user);
        return usersInfo;
    }

    @GetMapping(value = "/deleteUser")
    public String deleteUser(@RequestParam("userId") int id) {
        userService.deleteUser(id);
        return redirect;
    }
}