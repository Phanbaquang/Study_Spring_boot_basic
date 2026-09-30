package com.example.study_spring_boot.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class UserResponse {
    private String id;
    private String name;
    private String phone;
    private String address;
    private String email;
    private String username;
}
