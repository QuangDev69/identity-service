package com.dev.spring_boot.service;

import com.dev.spring_boot.dto.UserCreationRequest;
import com.dev.spring_boot.dto.UserUpdateRequest;
import com.dev.spring_boot.entity.User;

import java.util.List;

public interface UserService  {
    User createUser(UserCreationRequest userDTO);

    List<User> getUsers();

    User getUser(String userId);

    User updateUser(String userId, UserUpdateRequest request);

    void deleteUser(String userId);
}

