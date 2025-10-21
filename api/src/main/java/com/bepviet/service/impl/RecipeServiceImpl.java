package com.bepviet.service.impl;

import com.bepviet.builder.RecipeRequestBuilder;
import com.bepviet.converter.EntityToDtoConverter;
import com.bepviet.converter.RecipeBuilderConverter;
import com.bepviet.dto.ImageDto;
import com.bepviet.dto.RecipeDto;
import com.bepviet.dto.ReviewDto;
import com.bepviet.repository.RecipeRepository;
import com.bepviet.repository.entity.RecipeEntity;
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
                res.add(finalizeRecipe(recipeEntity));
            });
        }
        else{
            recipeRepository.findDistinctByNameOrDifficultyOrAverageRatingGreaterThanEqual(recipeRequestBuilder.getName(), recipeRequestBuilder.getDifficulty(), recipeRequestBuilder.getAverageRating()).forEach(
                    recipeEntity -> {
                        res.add(finalizeRecipe(recipeEntity));
                    }
            );

        }
        return res;
    }

    public RecipeDto finalizeRecipe(RecipeEntity recipeEntity) {
        List<ReviewDto> reviewDtoList = entityToDtoConverter.convertToDtoList(recipeEntity.getReviewEntities(), ReviewDto.class);
        List<String> ingredients = recipeEntity.getIngredientEntities().stream().map(ingredientEntity -> ingredientEntity.getName()).toList();
        List<ImageDto> imageDtoList = entityToDtoConverter.convertToDtoList(recipeEntity.getImageEntities(), ImageDto.class);
        RecipeDto recipeDto = entityToDtoConverter.convertToDto(recipeEntity, RecipeDto.class);
        recipeDto.setReviews(reviewDtoList);
        recipeDto.setIngredientList(ingredients);
        recipeDto.setImages(imageDtoList);
        return recipeDto;
    }
}
