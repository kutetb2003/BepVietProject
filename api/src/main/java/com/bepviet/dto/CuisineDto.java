package com.bepviet.dto;

import lombok.Data;

import java.util.List;

@Data
public class CuisineDto {
    private String name;
    private String description;
    private String imageUrl;
    private List<String> recipeNames;
}
