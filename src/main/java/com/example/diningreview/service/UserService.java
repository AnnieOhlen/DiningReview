package com.example.diningreview.service;

import com.example.diningreview.exception.GlobalExceptionHandler;
import com.example.diningreview.mapping.UserMapper;
import com.example.diningreview.model.User;
import com.example.diningreview.dto.UserDto;
import com.example.diningreview.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    /**
     * Get user by username
     * @param userName the user's username
     * @return UserDto returns the user
     * @throws GlobalExceptionHandler.UserNotFoundException if user is not found
     */
    public UserDto getUserByUserName(String userName) {
        User user = userRepository.findByUsername(userName).orElseThrow(()
                -> new GlobalExceptionHandler.UserNotFoundException(userName));
        return userMapper.modelToDto(user);
    }

    /**
     * Register a new user
     * @param userDto the user to register
     * @return UserDto returns the registered user
     */
    public UserDto registerUser(UserDto userDto) {
        logger.info("Registering user: {}", userDto);
        User user = userMapper.dtoToModel(userDto);
        logger.info("User model: {}", user);
        User savedUser = userRepository.save(user);
        return userMapper.modelToDto(savedUser);
    }

    /**
     * Delete user by username
     * @param userName the user's username
     * @return UserDto returns the deleted user
     * @throws GlobalExceptionHandler.UserNotFoundException if user is not found
     */
    public UserDto deleteUserByUserName(String userName) {
        User user = userRepository.findByUsername(userName).orElseThrow(()
                -> new GlobalExceptionHandler.UserNotFoundException(userName));
        userRepository.delete(user);
        return userMapper.modelToDto(user);
    }

}