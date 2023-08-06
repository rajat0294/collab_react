package com.spider.corespringsecurity.repository;

import com.spider.corespringsecurity.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepository extends MongoRepository<User, String> {
     Optional<User> findByUsername(String userName);
     Optional<User> findByRefreshToken_Token(String token);
}
