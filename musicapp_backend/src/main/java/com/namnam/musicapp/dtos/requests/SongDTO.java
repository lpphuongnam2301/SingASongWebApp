package com.namnam.musicapp.dtos.requests;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SongDTO {
    @NotBlank(message = "SONG_NAME_BLANK")
    private String name;

    private String thumbnail;
    private String description;
    private int likes;
    private String video;

    @JsonProperty("is_official")
    private boolean isOfficial;
}
