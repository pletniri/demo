package com.example.demo.controllers;

import com.example.demo.models.Account;
import com.example.demo.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegistersController {

    @Autowired
    private AccountService accountService;

    @GetMapping("/register")
    public String getRegisterPage(Model model){
        Account account = new Account();
        model.addAttribute("account", account);
        return "register";
    }

    @PostMapping("/register")
    public String registerNewUser(@ModelAttribute Account account) {
        accountService.save(account);

        return "redirect:/";
    }
}
