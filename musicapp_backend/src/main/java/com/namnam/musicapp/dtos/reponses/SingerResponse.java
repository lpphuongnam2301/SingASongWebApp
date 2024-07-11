package com.namnam.musicapp.dtos.reponses;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SingerResponse {
    private Long id;
    private String name;
    private Date dayOfBirth;
    private String description;
    private String thumbnail;
    private String officialLink;
    private int likes;

    private int totalPages;
}
