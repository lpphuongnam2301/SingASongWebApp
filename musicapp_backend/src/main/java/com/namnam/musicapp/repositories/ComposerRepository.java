package com.namnam.musicapp.repositories;

import com.namnam.musicapp.entities.Composer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComposerRepository extends JpaRepository<Composer, Long> {
}
