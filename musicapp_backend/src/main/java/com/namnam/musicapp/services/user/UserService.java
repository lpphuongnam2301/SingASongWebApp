package com.namnam.musicapp.services.user;

import com.namnam.musicapp.dtos.requests.UserDTO;
import com.namnam.musicapp.entities.User;
import com.namnam.musicapp.exceptions.AppException;
import com.namnam.musicapp.exceptions.ErrorCode;
import com.namnam.musicapp.mappers.UserMapper;
import com.namnam.musicapp.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.namnam.musicapp.exceptions.ErrorCode.PASSWORD_NOT_MATCH;

@Service
@RequiredArgsConstructor
public class UserService implements IUserService{
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    @Value("${api.password_cost}")//the strength of BCrypt (default 10)
    int password_cost;

    @Override
    public User createUser(UserDTO userDTO) {
        if(userRepository.existsByPhone(userDTO.getPhone()))
            throw new AppException(ErrorCode.USER_EXISTED);

        User newUser = userMapper.toUser(userDTO);

        //encode password by BCrypt
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(password_cost);
        newUser.setPassword(passwordEncoder.encode(userDTO.getPassword()));

        return userRepository.save(newUser);
    }

    @Override
    public User updateUser(String userId, UserDTO userDTO) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new AppException(ErrorCode.USER_NOT_FOUND));

        userMapper.updateUser(user, userDTO);

        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public String login(UserDTO userDTO) {
        var user = userRepository.findByPhone(userDTO.getPhone())
                .orElseThrow(() -> new AppException(ErrorCode.PHONE_NOT_FOUND));

        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(password_cost);

        if(!passwordEncoder.matches(user.getPassword(), passwordEncoder.encode(userDTO.getPassword())))
            throw new AppException(ErrorCode.PASSWORD_NOT_MATCH);

        return null;
    }


}
