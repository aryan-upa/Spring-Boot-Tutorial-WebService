package com.example.springboot.mobileappws;

import com.example.springboot.mobileappws.io.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserInterface extends CrudRepository<UserEntity, Long> {

}
