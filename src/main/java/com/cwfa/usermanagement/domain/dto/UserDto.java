package com.cwfa.usermanagement.domain.dto;

import lombok.Data;

import java.time.LocalDate;
@Data
public class UserDto {
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private LocalDate subscriptionDate;
    private Integer articlesRead;
}
