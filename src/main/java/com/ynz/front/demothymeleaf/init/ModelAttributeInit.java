package com.ynz.front.demothymeleaf.init;

import com.ynz.front.demothymeleaf.backingbeans.Login;
import com.ynz.front.demothymeleaf.controllers.ClientController;
import com.ynz.front.demothymeleaf.controllers.LoginController;
import com.ynz.front.demothymeleaf.dto.ClientDto;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

@ControllerAdvice(assignableTypes = {LoginController.class, ClientController.class})
public class ModelAttributeInit {

    @ModelAttribute
    public ClientDto clientDto() {
        return new ClientDto();
    }

    @ModelAttribute
    public Login login() {
        return new Login();
    }

}
