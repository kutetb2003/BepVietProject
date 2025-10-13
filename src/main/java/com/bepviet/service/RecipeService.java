package com.bepviet.service;

import com.bepviet.dto.RecipeDTO;

import java.util.List;

public interface RecipeService {
    List<RecipeDTO> findAll();
}
