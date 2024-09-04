package com.dev.spring_boot.service.impl;

import com.dev.spring_boot.dto.UserCreationRequest;
import com.dev.spring_boot.dto.UserUpdateRequest;
import com.dev.spring_boot.entity.User;
import com.dev.spring_boot.exception.AppException;
import com.dev.spring_boot.exception.ErrorCode;
import com.dev.spring_boot.mapper.UserMapper;
import com.dev.spring_boot.repositoty.UserRepository;
import com.dev.spring_boot.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public User createUser(UserCreationRequest request) {
        if(userRepository.existsByUsername(request.getUsername()))
            throw new AppException(ErrorCode.USER_EXISTED);
        User newUser = userMapper.toUser(request);

        return userRepository.save(newUser);
    }

    @Override
    public List<User> getUsers()
    {
        return userRepository.findAll();
    }

    @Override
    public User getUser(String userId) {
        return userRepository.findById(userId).orElseThrow(()-> new RuntimeException("User not found"));
    }

    @Override
    public User updateUser(String userId, UserUpdateRequest request) {
       User user = getUser(userId);
       userMapper.updateUser(request,user);

       return userRepository.save(user);
    }

    @Override
    public void deleteUser(String userId) {
        userRepository.deleteById(userId);
    }
}
