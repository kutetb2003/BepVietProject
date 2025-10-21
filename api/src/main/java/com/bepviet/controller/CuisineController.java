package com.bepviet.controller;

import com.bepviet.dto.CuisineDto;
import com.bepviet.service.CuisineService;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/api/cuisines/")
public class CuisineController {
    private final CuisineService cuisineService;
    public CuisineController(CuisineService cuisineService) {
        this.cuisineService = cuisineService;
    }

    @GetMapping("{id}")
    public CuisineDto findById(@PathVariable("id") Long id){
        System.out.println("Hello");
        return cuisineService.findById(id);
    }
    @GetMapping
    public List<CuisineDto> findAll(){
        return cuisineService.findAll();
    }
}
