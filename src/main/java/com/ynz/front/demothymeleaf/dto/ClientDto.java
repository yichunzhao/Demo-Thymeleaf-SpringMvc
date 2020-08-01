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
    @NotBlank
    @Size(min = 3, max = 25, message = "First name must be less than 25 and bigger than 3")
    private String firstName;
    @NotBlank
    @Size(min = 3, max = 25, message = "Last name must be less than 25 and bigger than 3")
    private String lastName;
    @NotBlank
    @Size(min = 11, max = 11, message = "Phone must be 11 characters.")
    private String phone;
}
