package com.namnam.musicapp.services.users;

import com.namnam.musicapp.dtos.requests.UserDTO;
import com.namnam.musicapp.entities.User;
import com.namnam.musicapp.exceptions.AppException;
import com.namnam.musicapp.exceptions.ErrorCode;
import com.namnam.musicapp.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService implements IUserService{
    private final UserRepository userRepository;

    @Override
    public User createUser(UserDTO userDTO) {
        if(userRepository.existsByPhoneNumber(userDTO.getPhone()))
            throw new AppException(ErrorCode.USER_EXISTED);

        User newUser = User.builder()
                .phone(userDTO.getPhone())
                .fullName(userDTO.getFullName())
                .password(userDTO.getPassword())
                .dateOfBirth(userDTO.getDateOfBirth())
                .address(userDTO.getAddress())
                .facebookAccountId(userDTO.getFacebookAccountId())
                .googleAccountId(userDTO.getGoogleAccountId())
                .active(true)
                .build();

        return userRepository.save(newUser);
    }

    @Override
    public User updateUser(String userID, UserDTO userDTO) {
        return null;
    }

}
