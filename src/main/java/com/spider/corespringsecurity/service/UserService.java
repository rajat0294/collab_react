package com.spider.corespringsecurity.service;

import com.spider.corespringsecurity.dto.request.UserSignUpRequest;
import com.spider.corespringsecurity.dto.response.UserResponse;
import com.spider.corespringsecurity.entity.User;
import com.spider.corespringsecurity.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    public UserResponse addUser(UserSignUpRequest userInfo) {
        User user=userRepository.save(User.builder()
                .email(userInfo.getEmail())
                .username(userInfo.getUsername())
                .password(passwordEncoder.encode(userInfo.getPassword()))
                .roleList(List.of("USER"))
                .build());

        return UserResponse.builder()
                .email(user.getEmail())
                .username(user.getUsername())
                .roleList(user.getRoleList())
                .build();
    }
}
