package com.example.eindopdracht.controllers;

import com.example.eindopdracht.dto.AccountDto;
import com.example.eindopdracht.dto.PropertyDto;
import com.example.eindopdracht.dto.UserDto;
import com.example.eindopdracht.repositories.RoleRepository;
import com.example.eindopdracht.repositories.UserRepository;
import com.example.eindopdracht.services.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // Handles HTTP requests and returns the response directly to the client
@RequestMapping("/users") // Using @RequestMapping sets the endpoint as a standard, unless specified otherwise
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/{userId}") // This method handles HTTP GET requests to the /users/{userId} endpoint, where {id} is a path variable representing the property ID
    public ResponseEntity<UserDto> getOneUser(@PathVariable String userId) {
        UserDto uDto = userService.getUser(userId);
        return new ResponseEntity<>(uDto, HttpStatus.OK);
    }

    @GetMapping // This method handles HTTP GET requests to the /users endpoint

    public ResponseEntity<List<UserDto>> getAllUsers() {
        List<UserDto> dDto = userService.getAllUsers();
        return new ResponseEntity<>(dDto, HttpStatus.OK);
    }
}
