package com.example.springdatajpa.Repository;

import com.example.springdatajpa.Domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class RepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CrudRepository<User, Long> crudRepository;

    @Test
    void Base_Repository의_Selective_함수_사용_여부() {
        // 저장 테스트 (save)
        User user = new User();
        user.setUsername("testuser");
        user.setEmail("test@example.com");
        userRepository.save(user);

        // 조회 테스트 (findById)
        Optional<User> retrievedUser = userRepository.findById(user.getId());
        assertTrue(retrievedUser.isPresent());
        assertEquals("testuser", retrievedUser.get().getUsername());

        // 커스텀 메서드 테스트 (findByEmail)
        Optional<User> emailUser = userRepository.findByEmail("test@example.com");
        assertTrue(emailUser.isPresent());
        assertEquals("testuser", emailUser.get().getUsername());
    }

    @Test
    void CrudRepository_직접사용_테스트() {
        // 저장 테스트
        User user = new User();
        user.setUsername("cruduser");
        user.setEmail("crud@example.com");
        crudRepository.save(user);

        // 조회 테스트
        Optional<User> retrievedUser = crudRepository.findById(user.getId());
        assertTrue(retrievedUser.isPresent());
        assertEquals("cruduser", retrievedUser.get().getUsername());
    }

}