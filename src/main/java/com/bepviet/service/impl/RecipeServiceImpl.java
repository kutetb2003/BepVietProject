package com.bepviet.service.impl;

import com.bepviet.converter.RecipeDTOConverter;
import com.bepviet.dto.RecipeDTO;
import com.bepviet.repository.RecipeRepository;
import com.bepviet.service.RecipeService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RecipeServiceImpl implements RecipeService {
    private final RecipeRepository recipeRepository;
    private final RecipeDTOConverter recipeDTOConverter;
    public RecipeServiceImpl(RecipeRepository recipeRepository, RecipeDTOConverter recipeDTOConverter) {
        this.recipeRepository = recipeRepository;
        this.recipeDTOConverter = recipeDTOConverter;
    }

    public List<RecipeDTO> findAll() {
        List<RecipeDTO> res = new ArrayList<>();
        recipeRepository.findAll().forEach(recipeEntity ->{
            res.add(recipeDTOConverter.convertToDTO(recipeEntity));
        });
        return res;
    }
}
