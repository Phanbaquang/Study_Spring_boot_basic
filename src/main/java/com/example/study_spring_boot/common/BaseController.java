package com.example.study_spring_boot.common;

public abstract class BaseController {
    protected  <T> ApiResponse <T> createResponse(T data){
        return  ApiResponse.success(data);
    }
}
