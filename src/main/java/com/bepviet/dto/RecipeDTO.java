package com.bepviet.dto;

import com.bepviet.enums.Difficulty;
import lombok.Data;

@Data
public class RecipeDTO {
    private Long id;
    private String name;
    private String description;
    private Difficulty difficulty;
}
