package com.example.DiningReview.service;

import com.example.DiningReview.dto.UserDto;
import com.example.DiningReview.mapping.UserMapper;
import com.example.DiningReview.model.User;
import com.example.DiningReview.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public UserDto registerUser(UserDto userDto) {
        User user = userMapper.dtoToModel(userDto);
        User savedUser = userRepository.save(user);
        return userMapper.modelToDto(savedUser);
    }

    public UserDto deleteUser(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(()
                -> new RuntimeException("User not found with id: " + userId));
        userRepository.delete(user);
        return userMapper.modelToDto(user);
    }

    public List<UserDto> getAllUsers() {
        List<User> users = userRepository.findAll();
        return userMapper.modelToDtoList(users);
    }

}