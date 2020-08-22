package com.ynz.front.demothymeleaf.controllers;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
@Slf4j
public class LogoutController {

    @GetMapping("/logoutSuccess")
    String logout(HttpSession session) {
        log.info("User successfully log out");

        return "logoutSuccess";
    }
}
