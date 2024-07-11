package com.namnam.musicapp.repositories;

import com.namnam.musicapp.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, String> {
    boolean existsByPhone(String phone);
    Optional<User> findByPhone(String phone);
    boolean existsByEmail(String email);
    Optional<User> findByEmail(String email);
}
