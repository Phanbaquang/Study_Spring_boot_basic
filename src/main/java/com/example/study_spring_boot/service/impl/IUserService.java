package com.example.study_spring_boot.service.impl;

import com.example.study_spring_boot.dto.record.UserRecordRequest;
import com.example.study_spring_boot.dto.record.UserRecordResponse;
import com.example.study_spring_boot.dto.request.UserRequest;
import com.example.study_spring_boot.dto.response.UserResponse;
import com.example.study_spring_boot.entity.User;
import com.example.study_spring_boot.mapper.Usermapper;
import com.example.study_spring_boot.repository.UserRepository;
import com.example.study_spring_boot.service.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class IUserService implements UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final Usermapper usermapper;

    @Override
    public void create(UserRecordRequest userRequest) {
        userRepository.save(User.builder()
                .name(userRequest.name())
                .password(userRequest.password())
                .username(userRequest.userName())
                .phone(userRequest.phone())
                .address(userRequest.address())
                .email(userRequest.email())
                .cccd(userRequest.cccd())
                .build());
    }

    @Override
    public UserResponse update(String id, UserRequest userRequest) {
        Optional<User> user = userRepository.findById(id);
        if (user.isEmpty()) {
            throw new IllegalArgumentException("User not found");
        }

        User userUpdate = user.get();
        userUpdate.setName(userRequest.getName());
        userUpdate.setAddress(userRequest.getAddress());
        userUpdate.setEmail(userRequest.getEmail());
        userUpdate.setPhone(userRequest.getPhone());
        userUpdate.setPassword(userRequest.getPassword());
        userRepository.save(userUpdate);
        return mapToResponse(userUpdate);
    }

    @Override
    public List<UserRecordResponse> index() {
        List<User> list = userRepository.findAll();
        return list.stream().map(usermapper::toResponse).toList();
    }

    @Override
    public void delete(String id) {
        userRepository.deleteById(id);
    }

    @Override
    public UserRecordResponse getDetail(String id) {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found" + id));
        return usermapper.toResponse(user);
    }

    private UserResponse mapToResponse(User user) {
//        modelMapper.map(user, UserResponse.class);
        return UserResponse.builder().
                address(user.getAddress())
                .id(user.getId())
                .name(user.getName())
                .phone(user.getPhone())
                .email(user.getEmail())
                .username(user.getUsername())
                .build();
    }
}
