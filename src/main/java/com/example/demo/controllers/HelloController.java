package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller

public class HelloController {
    @GetMapping(value = "/")
    public String printWelcome(ModelMap model) {
        List<String> messages = new ArrayList<>();
        messages.add("Welcome to our application!");
        messages.add("You can add the participants ");
        messages.add("of your event to the table");
        model.addAttribute("messages", messages);
        return "index";
    }
}
