package com.photokinisi.controllers;

import com.photokinisi.components.EmailTemplates;
import com.photokinisi.controllers.forms.FormDataContact;
import jakarta.validation.Valid;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/contact")
public class ContactController {
    @Autowired
    private EmailTemplates emailTemplates;

    @GetMapping
    public String handleRequest(Model model){
        model.addAttribute("formDataContact", new FormDataContact());
        return "contact";
    }


    @SneakyThrows
    @PostMapping
    public String handleRequest(Model model, @Valid @ModelAttribute("formDataContact") FormDataContact formDataContact, BindingResult bindingResult) {
        System.out.println(formDataContact);

        if (!bindingResult.hasErrors()) {
            model.addAttribute("success", true);
            emailTemplates.sendEmailToAdminContactForm(formDataContact);
            emailTemplates.sendEmailToClientContactForm(formDataContact);
        }

        return "contact";
    }

}