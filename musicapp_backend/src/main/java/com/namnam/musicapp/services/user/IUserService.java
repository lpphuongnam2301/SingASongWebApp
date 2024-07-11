package com.namnam.musicapp.services.user;

import com.namnam.musicapp.dtos.requests.UserDTO;
import com.namnam.musicapp.entities.User;

import java.util.List;

public interface IUserService {
    User createUser(UserDTO userDTO);
    User updateUser(String userId, UserDTO userDTO);
    List<User> getAllUser();

    String login(UserDTO userDTO);
}
