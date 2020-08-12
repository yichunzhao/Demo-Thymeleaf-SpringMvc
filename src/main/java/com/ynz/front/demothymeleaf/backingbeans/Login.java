package com.ynz.front.demothymeleaf.backingbeans;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class Login {
    @NotBlank(message = "Missing login name.")
    private String loginName;
    @NotBlank(message = "Missing password.")
    private String password;
}
