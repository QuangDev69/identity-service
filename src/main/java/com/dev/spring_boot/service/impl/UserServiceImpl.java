package com.dev.spring_boot.service.impl;

import com.dev.spring_boot.dto.UserCreationRequest;
import com.dev.spring_boot.dto.UserUpdateRequest;
import com.dev.spring_boot.entity.User;
import com.dev.spring_boot.enums.Role;
import com.dev.spring_boot.exception.AppException;
import com.dev.spring_boot.exception.ErrorCode;
import com.dev.spring_boot.mapper.UserMapper;
import com.dev.spring_boot.repositoty.UserRepository;
import com.dev.spring_boot.response.UserResponse;
import com.dev.spring_boot.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserResponse createUser(UserCreationRequest request) {
        if(userRepository.existsByUsername(request.getUsername()))
            throw new AppException(ErrorCode.USER_EXISTED);
        User newUser = userMapper.toUser(request);

        newUser.setPassword(passwordEncoder.encode(request.getPassword()));

        HashSet<String> roles =  new HashSet<>();
        roles.add(Role.USER.name());
        newUser.setRoles(roles);

        return userMapper.toUserResponse(userRepository.save(newUser));
    }

    @Override
    public List<UserResponse> getUsers()
    {
        return userRepository.findAll().stream().map(userMapper::toUserResponse).toList();
    }

    @Override
    public UserResponse getUser(String userId) {
        return userMapper.toUserResponse(userRepository.findById(userId).orElseThrow(()-> new RuntimeException("User not found")));
    }

    @Override
    public UserResponse updateUser(String userId, UserUpdateRequest request) {
        User user = userRepository.findById(userId).orElseThrow(()-> new RuntimeException("User not found"));
       userMapper.updateUser(request, user);
       return userMapper.toUserResponse(userRepository.save(user));
    }

    @Override
    public UserResponse getMyInfo() {
        var context = SecurityContextHolder.getContext();
        String name = context.getAuthentication().getName();

        User user = userRepository.findByUsername(name).orElseThrow(()-> new AppException(ErrorCode.USER_NOT_EXISTED));

        return userMapper.toUserResponse(user);
    }

    @Override
    public void deleteUser(String userId) {
        userRepository.deleteById(userId);
    }
}
