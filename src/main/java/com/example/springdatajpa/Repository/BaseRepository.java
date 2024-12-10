package com.example.springdatajpa.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.Optional;

@NoRepositoryBean
public interface BaseRepository<T, ID> extends CrudRepository<T, ID> {
    Optional<T> findById(ID id);
}
