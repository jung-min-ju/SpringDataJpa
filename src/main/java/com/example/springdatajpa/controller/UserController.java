package com.example.springdatajpa.controller;

import com.example.springdatajpa.Domain.User;
import com.example.springdatajpa.Service.UserService;
import com.example.springdatajpa.dto.AddUserReq;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/lab")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/add/user")
    public ResponseEntity<User> addUser(@RequestBody @Valid AddUserReq addUserReq) {
        userService.addUser(addUserReq);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
