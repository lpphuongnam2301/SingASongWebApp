package com.namnam.musicapp.mappers;

import com.namnam.musicapp.dtos.reponses.ComposerResponse;
import com.namnam.musicapp.dtos.reponses.UserResponse;
import com.namnam.musicapp.dtos.requests.ComposerDTO;
import com.namnam.musicapp.dtos.requests.UserDTO;
import com.namnam.musicapp.entities.Composer;
import com.namnam.musicapp.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ComposerMapper {
    Composer toComposer (ComposerDTO composerDTO);
    ComposerResponse toComposerResponse(Composer composer);
    void updateComposer(@MappingTarget Composer composer, ComposerDTO composerDTO);
}
