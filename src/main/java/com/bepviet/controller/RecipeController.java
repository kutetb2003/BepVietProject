package com.bepviet.controller;

import com.bepviet.dto.RecipeDTO;
import com.bepviet.service.RecipeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class RecipeController {
    private final RecipeService recipeService;
    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }
    @GetMapping("/api/recipe")
    public List<RecipeDTO> findAll(){
        return recipeService.findAll();
    }
}
