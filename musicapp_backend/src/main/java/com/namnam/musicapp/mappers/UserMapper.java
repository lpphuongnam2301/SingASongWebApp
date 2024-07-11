package com.namnam.musicapp.mappers;

import com.namnam.musicapp.dtos.reponses.UserResponse;
import com.namnam.musicapp.dtos.requests.UserDTO;
import com.namnam.musicapp.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toUser (UserDTO userDTO);
    UserResponse toUserResponse(User user);
    void updateUser(@MappingTarget User user, UserDTO userDTO);
}
