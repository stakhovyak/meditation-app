package com.weuoimi.user_service.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.weuoimi.user_service.entity.User;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

// TODO: The class is generated with GPT, it's trash, only for representation!!!!!

@RestController
@RequestMapping("/profiles")
public class UserController {

    @Operation(summary = "Get user profile by username")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Successfully retrieved user profile"),
        @ApiResponse(responseCode = "404", description = "User not found")
    })
    @GetMapping("/{username}")
    public String getUserProfile(@PathVariable String username) {
        // Method implementation
        return null;
    }

    @Operation(summary = "Register a new user")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "User successfully registered"),
        @ApiResponse(responseCode = "400", description = "Invalid input")
    })
    @PostMapping
    public String registerUser(@RequestBody User user) {
        // Method implementation
        return null;
    }

    @Operation(summary = "Update user profile")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "User profile successfully updated"),
        @ApiResponse(responseCode = "404", description = "User not found")
    })
    @PutMapping("/{username}")
    public String updateUserProfile(@PathVariable String username, @RequestBody User user) {
        // Method implementation
        return null;
    }

    @Operation(summary = "Delete a user")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "204", description = "User successfully deleted"),
        @ApiResponse(responseCode = "404", description = "User not found")
    })
    @DeleteMapping("/{username}")
    public void deleteUser(@PathVariable String username) {
        // Method implementation
    }

    @Operation(summary = "Get all users")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Successfully retrieved list of users")
    })
    @GetMapping
    public List<User> getAllUsers() {
        // Method implementation
        return null;
    }

    @Operation(summary = "Change user password")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Password successfully changed"),
        @ApiResponse(responseCode = "400", description = "Invalid input"),
        @ApiResponse(responseCode = "404", description = "User not found")
    })
    @PatchMapping("/{username}/password")
    public String changePassword(@PathVariable String username, @RequestBody PasswordChangeRequest passwordChangeRequest) {
        // Method implementation
        return null;
    }

    @Operation(summary = "Get user profile by email")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Successfully retrieved user profile"),
        @ApiResponse(responseCode = "404", description = "User not found")
    })
    @GetMapping("/email/{email}")
    public String getUserProfileByEmail(@PathVariable String email) {
        // Method implementation
        return null;
    }

    @Operation(summary = "Update user email")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Email successfully updated"),
        @ApiResponse(responseCode = "404", description = "User not found")
    })
    @PatchMapping("/{username}/email")
    public String updateEmail(@PathVariable String username, @RequestBody EmailUpdateRequest emailUpdateRequest) {
        // Method implementation
        return null;
    }
}

