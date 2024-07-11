package com.namnam.musicapp.dtos.reponses;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SongResponse {
    private Long id;
    private String name;
    private String thumbnail;
    private String description;
    private int likes;
    private boolean isOfficial;
    private String video;

    private int totalPages;
}
