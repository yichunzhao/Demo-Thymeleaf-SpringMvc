package com.ynz.front.demothymeleaf.controllers;

import com.ynz.front.demothymeleaf.repositories.ClientRepository;
import com.ynz.front.demothymeleaf.security.UserDetailServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpSession;

@Controller
@Slf4j
@SessionAttributes({"currentUser"})
@RequiredArgsConstructor
public class LoginController {
    private final UserDetailServiceImpl detailService;
    private final ClientRepository clientRepository;

    @GetMapping("/login")
    public String login(Model model) {
        log.info("Show login page.");
        return "login";
    }

    @PostMapping("/submitLogin")
    public String submitLogin(HttpSession session) {

        session.setMaxInactiveInterval(30);

        return "redirect:/showrooms";
    }

}
