package com.namnam.musicapp.repositories;

import com.namnam.musicapp.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
