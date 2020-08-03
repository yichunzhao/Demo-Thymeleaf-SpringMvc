package com.ynz.front.demothymeleaf.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClientDto {
    @NotBlank(message = "First name is mandatory")
    @Size(min = 3, max = 25, message = "First name length must be less than 25 and bigger than 3")
    private String firstName;

    @NotBlank(message = "Last name is mandatory")
    @Size(min = 3, max = 25, message = "Last name length must be less than 25 and bigger than 3")
    private String lastName;

    @NotBlank(message = "Email is mandatory")
    private String email;

    @NotBlank(message = "Phone number is mandatory")
    @Size(min = 8, max = 8, message = "Phone must contain 8 digits.")
    private String phone;
}
