package com.namnam.musicapp.services.users;

import com.namnam.musicapp.dtos.requests.UserDTO;
import com.namnam.musicapp.entities.User;

public interface IUserService {
    User createUser(UserDTO userDTO);
    User updateUser(String userID, UserDTO userDTO);

//    String login();
}
