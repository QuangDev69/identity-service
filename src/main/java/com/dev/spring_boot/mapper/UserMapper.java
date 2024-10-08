package com.dev.spring_boot.mapper;

import com.dev.spring_boot.dto.UserCreationRequest;
import com.dev.spring_boot.dto.UserUpdateRequest;
import com.dev.spring_boot.entity.User;
import com.dev.spring_boot.repositoty.UserRepository;
import com.dev.spring_boot.response.UserResponse;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toUser (UserCreationRequest request);
    UserResponse toUserResponse(User user);
    void updateUser(UserUpdateRequest request, @MappingTarget User user );
}
