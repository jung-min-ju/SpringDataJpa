package com.example.springdatajpa.dto;

import jakarta.validation.constraints.NotBlank;

public record AddUserReq (
        @NotBlank String firstName,
        @NotBlank String lastName,
        @NotBlank String email,
        @NotBlank String userName
)
{}

//record : 모든 필드가 자동으로 final로 선언되며, 불변성을 가짐.