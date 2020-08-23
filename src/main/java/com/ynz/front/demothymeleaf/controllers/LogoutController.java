package com.ynz.front.demothymeleaf.controllers;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class LogoutController {
    @Value("${logout.message}")
    private String logoutMsg;

    @GetMapping("/logoutSuccess")
    public String logout(Model model) {
        log.info("User successfully log out");

        model.addAttribute("message", logoutMsg);

        return "index";
    }
}
