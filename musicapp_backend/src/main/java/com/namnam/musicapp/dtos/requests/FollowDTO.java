package com.namnam.musicapp.dtos.requests;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FollowDTO {
    @NotNull(message = "Follower ID is required")
    @JsonProperty("follower_id")
    private Long followerId;

    @NotNull(message = "Following ID is required")
    @JsonProperty("following_id")
    private Long followingId;
}
