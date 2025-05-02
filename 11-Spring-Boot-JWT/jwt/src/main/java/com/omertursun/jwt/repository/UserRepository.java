package com.omertursun.jwt.repository;

import com.omertursun.jwt.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {


    //@Query("FROM User WHERE userName = :userName")
    Optional<User> findByUserName(String userName);




}
