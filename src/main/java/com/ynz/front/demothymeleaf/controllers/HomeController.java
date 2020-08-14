package com.ynz.front.demothymeleaf.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequiredArgsConstructor
@Slf4j
public class HomeController {

    @GetMapping("/")
    public String home(HttpSession session, Model model) {
        //We cannot use @SessionAttribute here, for when the first time entering the home; @SessionAttributes
        //has not been implemented. So we Session here.

        String user = (String) session.getAttribute("currentUser");
        model.addAttribute("currentUser", user);

        return "index";
    }

}
