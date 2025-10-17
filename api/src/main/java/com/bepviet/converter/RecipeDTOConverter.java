package com.bepviet.converter;

import com.bepviet.dto.RecipeDto;
import com.bepviet.repository.entity.RecipeEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class RecipeDTOConverter {
    private final ModelMapper modelMapper;
    public RecipeDTOConverter(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }
    public RecipeDto convertToDTO(RecipeEntity recipeEntity){
        return modelMapper.map(recipeEntity, RecipeDto.class);
    }

}
