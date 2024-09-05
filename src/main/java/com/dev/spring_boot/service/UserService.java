package com.dev.spring_boot.service;

import com.dev.spring_boot.dto.UserCreationRequest;
import com.dev.spring_boot.dto.UserUpdateRequest;
import com.dev.spring_boot.entity.User;
import com.dev.spring_boot.response.UserResponse;

import java.util.List;

public interface UserService  {
    User createUser(UserCreationRequest userDTO);

    List<User> getUsers();

    UserResponse getUser(String userId);

    UserResponse updateUser(String userId, UserUpdateRequest request);

    void deleteUser(String userId);
}

