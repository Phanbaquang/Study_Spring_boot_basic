package com.example.study_spring_boot.dto.record;

import com.example.study_spring_boot.annotation.Cccd;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UserRecordRequest(
        @NotNull(message = "k được null")
        String name,
        String phone,
        String email,
        String address,
        String password,
        String userName,
        @Cccd
        @NotBlank
        String cccd

)
{ }
