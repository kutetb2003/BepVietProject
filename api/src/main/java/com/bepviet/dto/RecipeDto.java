package com.bepviet.dto;

import com.bepviet.enums.Difficulty;
import lombok.Data;

@Data
public class RecipeDto {
    private Long id;
    private String name;
    private String description;
    private Difficulty difficulty;
    private Double averageRating;
}
