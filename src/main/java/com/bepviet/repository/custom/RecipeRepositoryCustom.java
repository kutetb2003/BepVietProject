package com.bepviet.repository.custom;

import com.bepviet.builder.RecipeRequestBuilder;
import com.bepviet.repository.entity.RecipeEntity;

import java.util.List;

public interface RecipeRepositoryCustom {
    List<RecipeEntity> findAllCustom(RecipeRequestBuilder recipeRequestBuilder);
}
