package com.namnam.musicapp.services.singer;

import com.namnam.musicapp.dtos.requests.SingerDTO;
import com.namnam.musicapp.entities.Singer;

import java.util.List;

public interface ISingerService {
    List<Singer> getAllSinger();

    Singer createSinger(SingerDTO singerDTO);

    Singer updateSinger(Long id, SingerDTO singerDTO);
}
