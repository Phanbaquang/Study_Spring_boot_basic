package com.example.study_spring_boot.exception;

import com.example.study_spring_boot.common.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@RestControllerAdvice
public class GlobalException {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ApiResponse<Map<String, String>> handleValidationException (MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(err -> {
            errors.put(err.getField() , err.getDefaultMessage());
        });
        return ApiResponse.errorListData(ErrorCode.DEFAULT_MESSAGE.getMessage(), ErrorCode.DEFAULT_MESSAGE.getCode(), errors);

    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ApiResponse<Objects>> handleRuntimeException (RuntimeException ex) {
        ApiResponse<Objects> apiResponse = ApiResponse.error("Có loi xảy ra", 999);
        return ResponseEntity.badRequest().body(apiResponse);
    }

}
