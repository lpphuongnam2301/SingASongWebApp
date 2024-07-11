package com.namnam.musicapp.dtos.reponses;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LoginResponse {
    boolean authenticated;
    String token;
}
