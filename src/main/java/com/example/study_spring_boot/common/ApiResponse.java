package com.example.study_spring_boot.common;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record ApiResponse<T>(int code, String message, T result) {

    public static <T> ApiResponse<T> success(T result) {
        return new ApiResponse<>(1000, "Thành công", result);
    }

    public static <T> ApiResponse<T> error(String message, int code) {
        return new ApiResponse<>(code, message, null);
    }

    public static <T> ApiResponse<T> errorListData(String message, int code, T result) {
        return new ApiResponse<>(code, message, result);
    }

}
