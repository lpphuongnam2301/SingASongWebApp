package com.namnam.musicapp.repositories;

import com.namnam.musicapp.entities.Song;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SongRepository extends JpaRepository<Song, Long> {
}
