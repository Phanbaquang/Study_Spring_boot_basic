package com.example.study_spring_boot.mapper;

import com.example.study_spring_boot.dto.record.UserRecordRequest;
import com.example.study_spring_boot.dto.record.UserRecordResponse;
import com.example.study_spring_boot.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface Usermapper {
    UserRecordResponse toResponse(User user);

    @Mapping(source = "name" , target = "email")
    User maptoEntity(UserRecordRequest request);
}
