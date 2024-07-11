package com.namnam.musicapp.mappers;

import com.namnam.musicapp.dtos.reponses.SingerResponse;
import com.namnam.musicapp.dtos.reponses.UserResponse;
import com.namnam.musicapp.dtos.requests.SingerDTO;
import com.namnam.musicapp.dtos.requests.UserDTO;
import com.namnam.musicapp.entities.Singer;
import com.namnam.musicapp.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface SingerMapper {
    Singer toSinger (SingerDTO singerDTO);
    SingerResponse toSingerResponse(Singer singer);
    void updateSinger(@MappingTarget Singer singer, SingerDTO singerDTO);
}
