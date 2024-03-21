package com.example.DiningReview.controller;

import com.example.DiningReview.dto.UserDto;
import com.example.DiningReview.repository.UserRepository;
import com.example.DiningReview.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<String> createNewUser(@RequestBody UserDto userDto) {
        UserDto userId = userService.registerUser(userDto);
        return ResponseEntity.ok("User created successfully with ID: " + userId);
    }



}
