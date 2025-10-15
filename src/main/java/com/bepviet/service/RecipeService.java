package com.bepviet.service;

import com.bepviet.dto.RecipeDTO;

import java.util.List;
import java.util.Map;

public interface RecipeService {
    List<RecipeDTO> findAll(Map<String, Object> params);
}
