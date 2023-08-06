package com.spider.corespringsecurity.service;

import com.spider.corespringsecurity.entity.RefreshToken;
import com.spider.corespringsecurity.entity.User;
import com.spider.corespringsecurity.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class RefreshTokenService {

    private final UserRepository userRepository;

    public RefreshToken createRefreshToken(String username) {

        return userRepository.findByUsername(username).map(user -> {
            RefreshToken refreshToken = RefreshToken.builder()
                    .token(UUID.randomUUID().toString())
                    .expiryDate(Instant.now().plusMillis(600000)).build();
            user.setRefreshToken(refreshToken);
            userRepository.save(user);
            return refreshToken;
        }).orElseThrow();
    }


    public Optional<User> findByToken(String token) {
        return userRepository.findByRefreshToken_Token(token);

    }


    public User verifyExpiration(User user) {
       if (user.getRefreshToken().getExpiryDate().compareTo(Instant.now()) < 0) {
           user.setRefreshToken(null);
           userRepository.save(user);
            throw new RuntimeException(user.getRefreshToken().getToken() + " Refresh token was expired. Please make a new signin request");
        }
        return user;
    }
}
