package com.bepviet.repository.impl;

import com.bepviet.builder.RecipeRequestBuilder;
import com.bepviet.entity.RecipeEntity;
import com.bepviet.repository.RecipeRepository;
import com.bepviet.repository.custom.RecipeRepositoryCustom;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RecipeRepositoryImpl implements RecipeRepositoryCustom {

    @Override
    public List<RecipeEntity> findAllCustom(RecipeRequestBuilder recipeRequestBuilder) {
        return List.of();
    }
}
