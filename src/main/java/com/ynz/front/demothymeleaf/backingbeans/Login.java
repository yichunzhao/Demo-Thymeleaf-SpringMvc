package com.ynz.front.demothymeleaf.backingbeans;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class Login {
    @NotBlank(message = "Missing user name.")
    private String userName;
    @NotBlank(message = "Missing password.")
    private String password;
}
