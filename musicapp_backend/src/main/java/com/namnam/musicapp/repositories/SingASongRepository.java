package com.namnam.musicapp.repositories;

import com.namnam.musicapp.entities.SingASong;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SingASongRepository extends JpaRepository<SingASong, Long> {
}
