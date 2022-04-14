package com.example.springboot.mobileappws.service.impl;

import com.example.springboot.mobileappws.UserRepository;
import com.example.springboot.mobileappws.io.entity.UserEntity;
import com.example.springboot.mobileappws.service.UserService;
import com.example.springboot.mobileappws.shared.dto.UserDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDto createUser(UserDto user) {
        UserEntity userEntity = new UserEntity();
        BeanUtils.copyProperties(user, userEntity);

        // HardCoding some values for testing.
        userEntity.setUserId("12345");
        userEntity.setEncryptedPassword("test");
        // All other values can be sent through JSON payload.

        UserEntity storedUserEntity = userRepository.save(userEntity);
        UserDto returnValue = new UserDto();

        BeanUtils.copyProperties(storedUserEntity, returnValue);

        return returnValue;
    }
}
