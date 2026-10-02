package com.example.study_spring_boot.mapper;

import com.example.study_spring_boot.dto.record.UserRecordRequest;
import com.example.study_spring_boot.dto.record.UserRecordResponse;
import com.example.study_spring_boot.entity.User;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-10-02T14:39:02+0700",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.12 (Microsoft)"
)
@Component
public class UsermapperImpl implements Usermapper {

    @Override
    public UserRecordResponse toResponse(User user) {
        if ( user == null ) {
            return null;
        }

        String id = null;
        String name = null;
        String phone = null;
        String email = null;
        String address = null;
        String cccd = null;

        id = user.getId();
        name = user.getName();
        phone = user.getPhone();
        email = user.getEmail();
        address = user.getAddress();
        cccd = user.getCccd();

        String userName = null;

        UserRecordResponse userRecordResponse = new UserRecordResponse( id, name, phone, email, address, userName, cccd );

        return userRecordResponse;
    }

    @Override
    public User maptoEntity(UserRecordRequest request) {
        if ( request == null ) {
            return null;
        }

        User.UserBuilder user = User.builder();

        user.email( request.name() );
        user.password( request.password() );
        user.name( request.name() );
        user.phone( request.phone() );
        user.address( request.address() );
        user.cccd( request.cccd() );

        return user.build();
    }
}
