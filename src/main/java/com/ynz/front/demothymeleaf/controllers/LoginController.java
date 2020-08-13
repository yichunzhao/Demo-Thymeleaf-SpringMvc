package com.ynz.front.demothymeleaf.controllers;

import com.ynz.front.demothymeleaf.backingbeans.Login;
import com.ynz.front.demothymeleaf.security.UserDetailServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@Slf4j
@SessionAttributes(names = "login")
public class LoginController {
    @Autowired
    private UserDetailServiceImpl detailService;

    @GetMapping("/login")
    public String login(SessionStatus sessionStatus) {
        if (sessionStatus != null) sessionStatus.setComplete();
        log.info("Show login page.");
        return "login";
    }

    @PostMapping("/submitLogin")
    public String submitLogin(@Valid @ModelAttribute Login login, BindingResult result, Model model, HttpSession session) {

        log.info("Accept login : " + login.toString());

        if (result.hasErrors()) {
            return "login";
        }

        if (!detailService.match(login)) {
            model.addAttribute("err", "UserName or Password is wrong");
            return "login";
        }

        session.setMaxInactiveInterval(30);

        return "redirect:/showrooms";

    }

}
