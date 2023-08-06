package com.spider.corespringsecurity.entity;


import lombok.Builder;
import lombok.Data;

import java.time.Instant;
@Data
@Builder
public class RefreshToken {
    private String token;
    private Instant expiryDate;
}
