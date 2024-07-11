package com.namnam.musicapp.services.song;

import com.namnam.musicapp.repositories.SongRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SongService implements ISongService {
    private final SongRepository songRepository;


}
