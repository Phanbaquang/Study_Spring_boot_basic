package com.example.study_spring_boot.dto.request;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserRequest {
    private String name;
    private String phone;
    private String address;
    private String email;
    private String password;
    private String username;
}
