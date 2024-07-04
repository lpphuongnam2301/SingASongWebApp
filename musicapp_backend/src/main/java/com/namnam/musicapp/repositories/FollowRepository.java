package com.namnam.musicapp.repositories;

import com.namnam.musicapp.entities.Follow;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FollowRepository extends JpaRepository<Follow, Long> {
}
