package com.spider.corespringsecurity.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
@Data
@Builder
public class User {

    @Id
    public String id;
    private String username;
    private String email;

    private String password;

    private List<String> roleList;

    private RefreshToken refreshToken;
}
