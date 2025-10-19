package com.bepviet.builder;

import com.bepviet.enums.Difficulty;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class RecipeRequestBuilder {
    private String name;
    private Difficulty difficulty;
    private Double averageRating;
}
