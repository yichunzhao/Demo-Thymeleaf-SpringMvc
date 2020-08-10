package com.ynz.front.demothymeleaf.controllers;

import com.ynz.front.demothymeleaf.backingbeans.Login;
import com.ynz.front.demothymeleaf.security.UserDetailServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class LoginController {
    @Autowired
    private UserDetailServiceImpl detailService;

    @GetMapping("/login")
    public String login() {
        log.info("Show login page.");
        return "login";
    }

    @PostMapping("/submitLogin")
    public String submitLogin(@ModelAttribute Login login, Model model) {
        log.info("Accept login : " + login.toString());

        if (detailService.match(login)) {
            return "redirect:/showrooms";
        } else {
            model.addAttribute("err", "UserName or Password is wrong");
            return "login";
        }

    }

//    @PostMapping("/login")
//    public String submitLogin(@ModelAttribute Login login) {
//        log.info("Accept login : " + login.toString());
//
//        //if it fails to login, then go to a page showing error
//
//        //if login is successful, then go to a page showing all rooms
//        return "redirect:/showrooms";
//    }


}
