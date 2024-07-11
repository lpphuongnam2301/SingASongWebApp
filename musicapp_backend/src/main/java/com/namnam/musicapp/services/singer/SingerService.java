package com.namnam.musicapp.services.singer;

import com.namnam.musicapp.dtos.requests.SingerDTO;
import com.namnam.musicapp.entities.Singer;
import com.namnam.musicapp.exceptions.AppException;
import com.namnam.musicapp.exceptions.ErrorCode;
import com.namnam.musicapp.mappers.SingerMapper;
import com.namnam.musicapp.repositories.SingerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SingerService implements ISingerService {
    private final SingerRepository singerRepository;
    private final SingerMapper singerMapper;

    @Override
    public List<Singer> getAllSinger() {
        return singerRepository.findAll();
    }

    @Override
    public Singer createSinger(SingerDTO singerDTO) {
        Singer singer = singerMapper.toSinger(singerDTO);

        return singerRepository.save(singer);
    }

    @Override
    public Singer updateSinger(Long id, SingerDTO singerDTO) {
        Singer singer = singerRepository.findById(id)
                .orElseThrow(() -> new AppException(ErrorCode.SINGER_NOT_FOUND));

        singerMapper.updateSinger(singer, singerDTO);

        return singerRepository.save(singer);
    }
}
