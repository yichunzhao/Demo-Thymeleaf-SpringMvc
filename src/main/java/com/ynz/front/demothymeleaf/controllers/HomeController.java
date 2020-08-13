package com.ynz.front.demothymeleaf.controllers;

import com.ynz.front.demothymeleaf.backingbeans.Login;
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
        Login login = (Login) session.getAttribute("login");
        if (login != null) model.addAttribute("currentUser", login.getLoginName());
        return "index";
    }

}
