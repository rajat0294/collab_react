package com.spider.corespringsecurity.dto.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserSignUpRequest {
    private String username;
    private String email;

    private String password;

}
