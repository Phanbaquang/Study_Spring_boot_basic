package com.example.study_spring_boot.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    DEFAULT_MESSAGE(1000, "Có lỗi xảy ra");
    private int code;
    private String message;
}
