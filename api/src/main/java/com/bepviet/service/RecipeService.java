package com.bepviet.service;

import com.bepviet.dto.RecipeDto;

import java.util.List;
import java.util.Map;

public interface RecipeService {
    List<RecipeDto> findAll(Map<String, Object> params);
}
