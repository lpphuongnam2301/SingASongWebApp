package com.namnam.musicapp.dtos.requests;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SingerDTO {
    @NotBlank(message = "SINGER_NAME_BLANK")
    private String name;

    private String thumbnail;
    private String description;
    private int likes;

    @JsonProperty("official_link")
    private String officialLink;
}
