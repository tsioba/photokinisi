package com.photokinisi.controllers;

import com.photokinisi.repositories.entities.User;
import com.photokinisi.services.AuthService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class AuthController {

    @Autowired
    private AuthService authService;

    @GetMapping("/login")
    public String handleRequest(Model model) {
        return "login";
    }


    @GetMapping("/do-logout")
    public String handleRequest2(Model model) {
        return "logout";
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

//    @PostMapping("/register")
//    public String registerUser(@ModelAttribute("user") @Valid User user, BindingResult result) {
//        if (result.hasErrors()) {
//            return "register";
//        }
//
//        authService.registerUser(user);
//        return "redirect:/login";
//    }
}
