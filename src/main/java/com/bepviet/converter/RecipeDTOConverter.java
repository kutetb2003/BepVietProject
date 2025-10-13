package com.bepviet.converter;

import com.bepviet.dto.RecipeDTO;
import com.bepviet.entity.RecipeEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class RecipeDTOConverter {
    private final ModelMapper modelMapper;
    public RecipeDTOConverter(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }
    public RecipeDTO convertToDTO(RecipeEntity recipeEntity){
        return modelMapper.map(recipeEntity, RecipeDTO.class);
    }

}
