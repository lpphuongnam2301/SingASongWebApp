package com.namnam.musicapp.repositories;

import com.namnam.musicapp.entities.Singer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SingerRepository extends JpaRepository<Singer, Long> {
}
