package com.example.springboot.mobileappws;

import com.example.springboot.mobileappws.io.entity.UserEntity;
import org.apache.catalina.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Long> {
    /*
    Function to determine whether user exists in the database or not by matching incoming request with email.
     */
    UserEntity findByEmail(String email);
}
