package com.example.eindopdracht.dto;

import jakarta.validation.constraints.*;
import lombok.Data;


@Data
public class AccountDto { //This class serves as a data structure for transferring data related to user accounts between different parts of the application

    public Long accountId;
    @NotEmpty(message = "First name cannot be empty")
    public String firstname;
    @NotEmpty(message = "Last name cannot be empty")
    public String lastname;
    @Email(message = "This needs to be a valid email address")
    public String email;

    @NotEmpty
    public String username;
    @NotEmpty
    public String password;

}
