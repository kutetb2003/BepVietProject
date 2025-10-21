package com.bepviet.service.impl;

import com.bepviet.converter.EntityToDtoConverter;
import com.bepviet.dto.CuisineDto;
import com.bepviet.repository.CuisineRepository;
import com.bepviet.repository.entity.CuisineEntity;
import com.bepviet.service.CuisineService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;
import java.util.List;

@Service
public class CuisineServiceImpl implements CuisineService {
    private final CuisineRepository cuisineRepository;
    private final EntityToDtoConverter entityToDtoConverter;
    public CuisineServiceImpl(CuisineRepository cuisineRepository, EntityToDtoConverter entityToDtoConverter) {
        this.entityToDtoConverter = entityToDtoConverter;
        this.cuisineRepository = cuisineRepository;
    }

    public CuisineDto findById(Long id){
        Optional<CuisineEntity> cuisineEntity = cuisineRepository.findById(id);
        if(cuisineEntity.isPresent()){
            CuisineDto cuisineDto = finalizeCuisine(cuisineEntity.get());
            return cuisineDto;
        }
        return null;
    }
    public List<CuisineDto> findAll(){
        List<CuisineDto> res = new ArrayList<>();
        cuisineRepository.findAll().forEach(cuisineEntity -> {
            res.add(finalizeCuisine(cuisineEntity));
        });
        return res;
    }

    public CuisineDto finalizeCuisine(CuisineEntity cuisineEntity){
        CuisineDto cuisineDto = entityToDtoConverter.convertToDto(cuisineEntity, CuisineDto.class);
        List<String> recipeNames = cuisineEntity.getRecipeEntities().stream().map(recipeEntity -> recipeEntity.getName()).toList();
        cuisineDto.setRecipeNames(recipeNames);
        return cuisineDto;
    }
}
