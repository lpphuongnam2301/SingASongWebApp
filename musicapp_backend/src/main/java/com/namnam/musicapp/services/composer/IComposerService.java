package com.namnam.musicapp.services.composer;

import com.namnam.musicapp.dtos.requests.ComposerDTO;
import com.namnam.musicapp.entities.Composer;

import java.util.List;

public interface IComposerService {
    List<Composer> getAllComposer();

    Composer createComposer(ComposerDTO composerDTO);

    Composer updateComposer(Long id, ComposerDTO composerDTO);
}
