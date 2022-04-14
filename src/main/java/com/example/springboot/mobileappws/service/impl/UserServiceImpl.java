package com.example.springboot.mobileappws.service.impl;

import com.example.springboot.mobileappws.MobileAppWsApplication;
import com.example.springboot.mobileappws.UserRepository;
import com.example.springboot.mobileappws.io.entity.UserEntity;
import com.example.springboot.mobileappws.service.UserService;
import com.example.springboot.mobileappws.shared.Utils;
import com.example.springboot.mobileappws.shared.dto.UserDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    Utils utils;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserDto createUser(UserDto user) throws RuntimeException {

        UserEntity storedUserDetails = userRepository.findByEmail(user.getEmail());

        if(storedUserDetails != null)
            throw new RuntimeException("Record Already Exists!!");

        UserEntity userEntity = new UserEntity();
        BeanUtils.copyProperties(user, userEntity);

        userEntity.setUserId(utils.generateRandomUserId(30));
        userEntity.setEncryptedPassword(bCryptPasswordEncoder.encode(user.getPassword()));

        UserEntity storedUserEntity = userRepository.save(userEntity);
        UserDto returnValue = new UserDto();

        BeanUtils.copyProperties(storedUserEntity, returnValue);

        return returnValue;
    }
}
