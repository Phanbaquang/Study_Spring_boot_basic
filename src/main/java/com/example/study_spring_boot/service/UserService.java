package com.example.study_spring_boot.service;

import com.example.study_spring_boot.dto.record.UserRecordRequest;
import com.example.study_spring_boot.dto.record.UserRecordResponse;
import com.example.study_spring_boot.dto.request.UserRequest;
import com.example.study_spring_boot.dto.response.UserResponse;

import java.util.List;

public interface UserService {
    void create(UserRecordRequest userRequest);
    UserResponse update(String id, UserRequest userRequest);
    List<UserRecordResponse> index();
    void  delete(String id);
    UserRecordResponse getDetail(String id);
}
