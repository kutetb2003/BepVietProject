package com.bepviet.service.impl;

import com.bepviet.builder.RecipeRequestBuilder;
import com.bepviet.converter.RecipeBuilderConverter;
import com.bepviet.converter.RecipeDTOConverter;
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
    private final RecipeDTOConverter recipeDTOConverter;
    private final RecipeBuilderConverter recipeBuilderConverter;
    public RecipeServiceImpl(RecipeRepository recipeRepository, RecipeDTOConverter recipeDTOConverter, RecipeBuilderConverter recipeBuilderConverter) {
        this.recipeRepository = recipeRepository;
        this.recipeDTOConverter = recipeDTOConverter;
        this.recipeBuilderConverter = recipeBuilderConverter;
    }

    public List<RecipeDto> findAll(Map<String, Object> params) {
        List<RecipeDto> res = new ArrayList<>();
        RecipeRequestBuilder recipeRequestBuilder = recipeBuilderConverter.toRecipeRequestBuilder(params);
        if(params.isEmpty()){
            recipeRepository.findAll().forEach(recipeEntity ->{
                res.add(recipeDTOConverter.convertToDTO(recipeEntity));
            });
        }
        else{
            recipeRepository.findDistinctByNameOrDifficulty(recipeRequestBuilder.getName(), recipeRequestBuilder.getDifficulty()).forEach(
                    recipeEntity -> {
                        res.add(recipeDTOConverter.convertToDTO(recipeEntity));
                    }
            );

        }
        return res;
    }
}
