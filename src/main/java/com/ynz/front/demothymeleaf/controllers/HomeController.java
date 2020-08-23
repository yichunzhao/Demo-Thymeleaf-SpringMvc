package com.ynz.front.demothymeleaf.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
@Slf4j
public class HomeController {
    @Value("${welcome.message}")
    private String welcomeMsg;

    @GetMapping({"/", "/home"})
    public String home(Model model, Principal principal) {
        log.info("Get index page");

        if (principal == null) model.addAttribute("currentUser", null);
        else model.addAttribute("currentUser", principal.getName());

        model.addAttribute("message", welcomeMsg);

        return "index";
    }

}
