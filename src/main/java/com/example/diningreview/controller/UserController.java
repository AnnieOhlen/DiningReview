package com.example.diningreview.controller;

import com.example.diningreview.dto.UserDto;
import com.example.diningreview.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/api/users")
@Tag(name = "User Controller", description = "Operations pertaining to user management")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{userName}")
    @Operation(summary = "Get user", description = "Get user by username")
    public ResponseEntity<UserDto> getUserByUserName(@Valid @PathVariable String userName) {
        UserDto user = userService.getUserByUserName(userName);
        return ResponseEntity.ok(user);
    }

    @PostMapping("/register")
    @Operation(summary = "Register user", description = "Register new user")
    public ResponseEntity<UserDto> registerUser(@Valid  @RequestBody UserDto userDto) {
        UserDto newUser = userService.registerUser(userDto);
        return ResponseEntity.ok(newUser);
    }

    @DeleteMapping("/{userName}")
    @Operation(summary = "Delete user", description = "Delete user by username")
    public ResponseEntity<UserDto> deleteUser(@Valid @PathVariable String userName) {
        UserDto removedUser = userService.deleteUserByUserName(userName);
        return ResponseEntity.ok(removedUser);
    }

}
