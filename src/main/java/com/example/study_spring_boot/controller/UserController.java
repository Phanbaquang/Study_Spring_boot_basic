package com.example.study_spring_boot.controller;

import com.example.study_spring_boot.common.ApiResponse;
import com.example.study_spring_boot.common.BaseController;
import com.example.study_spring_boot.dto.record.UserRecordRequest;
import com.example.study_spring_boot.dto.record.UserRecordResponse;
import com.example.study_spring_boot.dto.request.UserRequest;
import com.example.study_spring_boot.dto.response.UserResponse;
import com.example.study_spring_boot.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController extends BaseController {
    private final UserService userService;

    @GetMapping
    ApiResponse<List<UserRecordResponse>> getAllUssr() {
        return createResponse(userService.index());
    }

    @PostMapping
    ApiResponse createUser(@Valid @RequestBody UserRecordRequest userRequest) {
        userService.create(userRequest);
        return createResponse("tạo user thành công");
    }

    @DeleteMapping("/{id}")
    String deleteUser(@PathVariable String id) {
        userService.delete(id);
        return "xóa user thành công";
    }

    @GetMapping("/{id}")
    ApiResponse getDetailUser(@PathVariable String id) {
        return createResponse(userService.getDetail(id));
    }

    @PutMapping("/{id}")
    ApiResponse<UserResponse> updateUser(@PathVariable String id, @RequestBody UserRequest request){
        return createResponse(userService.update(id , request));
    }

}
