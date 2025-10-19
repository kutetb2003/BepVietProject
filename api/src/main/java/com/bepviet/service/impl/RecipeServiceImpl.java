package com.bepviet.service.impl;

import com.bepviet.builder.RecipeRequestBuilder;
import com.bepviet.converter.EntityToDtoConverter;
import com.bepviet.converter.RecipeBuilderConverter;
import com.bepviet.dto.RecipeDto;
import com.bepviet.repository.RecipeRepository;
import com.bepviet.service.RecipeService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class RecipeServiceImpl implements RecipeService {
    private final RecipeRepository recipeRepository;
    private final EntityToDtoConverter entityToDtoConverter;
    private final RecipeBuilderConverter recipeBuilderConverter;
    public RecipeServiceImpl(RecipeRepository recipeRepository,  EntityToDtoConverter entityToDtoConverter, RecipeBuilderConverter recipeBuilderConverter) {
        this.recipeRepository = recipeRepository;
        this.entityToDtoConverter = entityToDtoConverter;
        this.recipeBuilderConverter = recipeBuilderConverter;
    }

    public List<RecipeDto> findAll(Map<String, Object> params) {
        List<RecipeDto> res = new ArrayList<>();
        RecipeRequestBuilder recipeRequestBuilder = recipeBuilderConverter.toRecipeRequestBuilder(params);
        if(params.isEmpty()){
            recipeRepository.findAll().forEach(recipeEntity ->{
                res.add(entityToDtoConverter.convertToDto(recipeEntity, RecipeDto.class));
            });
        }
        else{
            recipeRepository.findDistinctByNameOrDifficultyOrAverageRatingGreaterThanEqual(recipeRequestBuilder.getName(), recipeRequestBuilder.getDifficulty(), recipeRequestBuilder.getAverageRating()).forEach(
                    recipeEntity -> {
                        res.add(entityToDtoConverter.convertToDto(recipeEntity, RecipeDto.class));
                    }
            );

        }
        return res;
    }
}
