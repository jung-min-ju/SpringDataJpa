package com.example.springdatajpa.Service;

import com.example.springdatajpa.Domain.User;
import com.example.springdatajpa.Repository.UserRepository;
import com.example.springdatajpa.dto.AddUserReq;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final CrudRepository crudRepository;
    @Override
    public void addUser(AddUserReq addUserReq) {
        User user = new User();
        user.setEmail(addUserReq.email());
        user.setFirstname(addUserReq.firstName());
        user.setLastname(addUserReq.lastName());
        user.setUsername(addUserReq.userName());
        userRepository.save(user);
    }
}
