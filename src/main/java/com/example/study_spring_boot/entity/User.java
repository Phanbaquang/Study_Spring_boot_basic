package com.example.study_spring_boot.entity;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "users")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String username;
    private String password;
    private String name;
    @Column(length = 10, name = "phoneNumber")
    private String phone;
    private String address;
    @Column(unique = true)
    private String email;
    private String cccd;
}
