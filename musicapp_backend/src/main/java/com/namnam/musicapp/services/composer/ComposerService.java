package com.namnam.musicapp.services.composer;

import com.namnam.musicapp.dtos.requests.ComposerDTO;
import com.namnam.musicapp.entities.Composer;
import com.namnam.musicapp.exceptions.AppException;
import com.namnam.musicapp.exceptions.ErrorCode;
import com.namnam.musicapp.mappers.ComposerMapper;
import com.namnam.musicapp.repositories.ComposerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ComposerService implements IComposerService {
    private final ComposerRepository composerRepository;
    private final ComposerMapper composerMapper;

    @Override
    public List<Composer> getAllComposer() {
        return composerRepository.findAll();
    }

    @Override
    public Composer createComposer(ComposerDTO composerDTO) {
        Composer composer = composerMapper.toComposer(composerDTO);

        return composerRepository.save(composer);
    }

    @Override
    public Composer updateComposer(Long id, ComposerDTO composerDTO) {
        Composer composer = composerRepository.findById(id)
                .orElseThrow(() -> new AppException(ErrorCode.COMPOSER_NOT_FOUND));

        composerMapper.updateComposer(composer, composerDTO);

        return composerRepository.save(composer);
    }
}
