package com.bepviet.controller;

import com.bepviet.dto.RecipeDto;
import com.bepviet.exception.FieldRequiredException;
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
    public List<RecipeDto> findAll(@RequestParam(required = false) Map<String, Object> params){
        if(params.get("name") == null){
            throw new FieldRequiredException("Name is required");
        }
        return recipeService.findAll(params);
    }
}
