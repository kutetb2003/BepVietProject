package com.bepviet.controller;

import com.bepviet.dto.RecipeDTO;
import com.bepviet.service.RecipeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class RecipeController {
    private final RecipeService recipeService;
    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }
    @GetMapping("/api/recipes/")
    public List<RecipeDTO> findAll(@RequestParam(required = false) Map<String, Object> params){
        return recipeService.findAll(params);
    }
}
