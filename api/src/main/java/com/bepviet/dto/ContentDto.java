package com.bepviet.dto;

import lombok.Data;

import java.util.List;

@Data
public class ContentDto {
    private Long id;
    private String name;
    private String description;
    private Double averageRating;
    private List<ReviewDto> reviews;
}
