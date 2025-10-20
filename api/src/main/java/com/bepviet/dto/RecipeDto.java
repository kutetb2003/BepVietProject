package com.bepviet.dto;

import com.bepviet.enums.Difficulty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;


@Data
@EqualsAndHashCode(callSuper = true)
public class RecipeDto extends ContentDto {
    private Difficulty difficulty;
    private String creatorName;
    private List<String> ingredientList;
}
