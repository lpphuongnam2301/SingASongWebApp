package com.namnam.musicapp.dtos.requests;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SingASong {
    @JsonProperty("rating_point")
    @Size(min = 0, max = 5, message = "Rating point must be from 0 to 5")
    private Float ratingPoint;

    @JsonProperty("total_rated")
    private int totalRated;

    private String description;

    private int views;
    private int likes;

    @NotNull(message = "Song ID is required")
    @JsonProperty("song_id")
    private Long songId;

    @NotNull(message = "User ID is required")
    @JsonProperty("user_id")
    private Long userId;
}
