package com.bepviet.dto;

import lombok.Data;

import java.util.List;

@Data
public class ErrorResponseDto {
    private String error;
    private List<String> details;
}
