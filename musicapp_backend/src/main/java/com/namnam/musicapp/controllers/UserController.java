package com.namnam.musicapp.controllers;

import com.namnam.musicapp.dtos.reponses.ApiResponse;
import com.namnam.musicapp.dtos.requests.UserDTO;
import com.namnam.musicapp.entities.User;
import com.namnam.musicapp.services.users.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "${api.prefix}/users")
public class UserController {
    private final UserService userService;

    @PostMapping("/register")
    public ApiResponse<User> createUser(@RequestBody @Valid UserDTO userDTO)
    {
        ApiResponse<User> apiResponse = new ApiResponse<>();
        apiResponse.setResult(userService.createUser(userDTO));
        return apiResponse;
    }
}
