package com.spider.corespringsecurity.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class ErrorDto {
    private String msg;
    private int code;
    @Builder.Default
    private boolean error=true;
}
