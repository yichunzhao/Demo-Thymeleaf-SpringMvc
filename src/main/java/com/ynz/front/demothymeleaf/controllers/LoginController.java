package com.ynz.front.demothymeleaf.controllers;

import com.ynz.front.demothymeleaf.backingbeans.Login;
import com.ynz.front.demothymeleaf.repositories.ClientRepository;
import com.ynz.front.demothymeleaf.security.UserDetailServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

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
    public String submitLogin(@Valid @ModelAttribute("login") Login login, BindingResult result, Model model, HttpSession session) {
        log.info("Accept login : " + login.toString());

        if (result.hasErrors()) {
            return "login";
        }

        if (!detailService.match(login)) {
            model.addAttribute("err", "UserName or Password is wrong");
            return "login";
        }

        //login is successful
        model.addAttribute("currentUser", login.getLoginName());

        //email is the login name
        String currentUser = clientRepository.findByEmail(login.getLoginName())
                .map(client -> client.getFirstName()).orElse(null);
        model.addAttribute("currentUser", currentUser);

        session.setMaxInactiveInterval(30);

        return "redirect:/showrooms";
    }

}
