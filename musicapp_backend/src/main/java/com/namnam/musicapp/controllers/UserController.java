package com.namnam.musicapp.controllers;

import com.namnam.musicapp.dtos.reponses.ApiResponse;
import com.namnam.musicapp.dtos.reponses.LoginResponse;
import com.namnam.musicapp.dtos.reponses.UserResponse;
import com.namnam.musicapp.dtos.requests.UserDTO;
import com.namnam.musicapp.entities.User;
import com.namnam.musicapp.mappers.UserMapper;
import com.namnam.musicapp.services.user.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "${api.prefix}/users")
public class UserController {
    private final UserService userService;
    private final UserMapper userMapper;

    @GetMapping("")
    public ApiResponse<List<UserResponse>> getAllUser()
    {
        List<UserResponse> usersResponse = userService.getAllUser()
                .stream().map(userMapper::toUserResponse).toList();
        ApiResponse<List<UserResponse>> apiResponse = new ApiResponse<>();
        apiResponse.setResult(usersResponse);
        return apiResponse;
    }

    @PostMapping("/login")
    public ApiResponse<LoginResponse> login(@RequestBody @Valid UserDTO userDTO)
    {
        ApiResponse<LoginResponse> apiResponse = new ApiResponse<>();

        apiResponse.setResult(LoginResponse.builder()
                .token(userService.login(userDTO))
                .build());

        return apiResponse;
    }

    @PostMapping("/register")
    public ApiResponse<UserResponse> createUser(@RequestBody @Valid UserDTO userDTO)
    {
        ApiResponse<UserResponse> apiResponse = new ApiResponse<>();
        apiResponse.setResult(userMapper.toUserResponse(userService.createUser(userDTO)));
        return apiResponse;
    }

    @PostMapping("/update/{id}")
    public ApiResponse<UserResponse> updateUser(@PathVariable String userId, @RequestBody @Valid UserDTO userDTO)
    {
        ApiResponse<UserResponse> apiResponse = new ApiResponse<>();
        apiResponse.setResult(userMapper.toUserResponse(userService.updateUser(userId, userDTO)));
        return apiResponse;
    }
}
