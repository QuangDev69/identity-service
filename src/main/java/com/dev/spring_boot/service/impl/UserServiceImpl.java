package com.dev.spring_boot.service.impl;

import com.dev.spring_boot.dto.UserCreationRequest;
import com.dev.spring_boot.dto.UserUpdateRequest;
import com.dev.spring_boot.entity.User;
import com.dev.spring_boot.exception.AppException;
import com.dev.spring_boot.exception.ErrorCode;
import com.dev.spring_boot.repositoty.UserRepository;
import com.dev.spring_boot.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public User createUser(UserCreationRequest request) {
        User newUser = new User();
        if(userRepository.existsByUsername(request.getUsername()))
            throw new AppException(ErrorCode.USER_EXISTED);


        newUser.setUsername(request.getUsername());
        newUser.setBirthday(request.getBirthday());
        newUser.setEmail(request.getEmail());
        newUser.setFirstName(request.getFirstName());
        newUser.setLastName(request.getLastName());
        newUser.setPassword(request.getPassword());
        newUser.setPhoneNumber(request.getPhoneNumber());
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
       user.setPhoneNumber(request.getPhoneNumber());
       user.setPassword(request.getPassword());
       user.setFirstName(request.getFirstName());
       user.setLastName(request.getLastName());
       user.setEmail(request.getEmail());
       user.setBirthday(request.getBirthday());

       return userRepository.save(user);
    }

    @Override
    public void deleteUser(String userId) {
        userRepository.deleteById(userId);
    }
}
