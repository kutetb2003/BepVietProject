package com.bepviet.converter;

import com.bepviet.builder.RecipeRequestBuilder;
import com.bepviet.enums.Difficulty;
import com.bepviet.utils.MapUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class RecipeBuilderConverter {
    public RecipeRequestBuilder toRecipeRequestBuilder(Map<String, Object> params){
        RecipeRequestBuilder recipeRequestBuilder = RecipeRequestBuilder.builder()
                .name(MapUtil.getObject(params, "name", String.class))
                .difficulty(MapUtil.getObject(params, "difficulty", Difficulty.class))
                .build();
        return recipeRequestBuilder;
    }
}
