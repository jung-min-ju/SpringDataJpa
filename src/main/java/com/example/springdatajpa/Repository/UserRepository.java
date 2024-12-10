package com.example.springdatajpa.Repository;

import com.example.springdatajpa.Domain.User;

import java.util.Optional;

public interface UserRepository extends BaseRepository<User, Long> {
    Optional<User> findByEmail(String email);
}