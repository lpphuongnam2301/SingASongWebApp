package com.namnam.musicapp.dtos.reponses;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserResponse {
    private String phone;
    private String password;
    private String fullName;
    private String address;
    private Date dateOfBirth;
    private String avatar;
}
