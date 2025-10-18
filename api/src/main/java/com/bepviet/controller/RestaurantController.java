package com.bepviet.controller;

import com.bepviet.dto.RestaurantDto;
import com.bepviet.service.RestaurantService;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class RestaurantController {
    private final RestaurantService restaurantService;
    public RestaurantController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    @GetMapping("/api/restaurants/")
    public List<RestaurantDto> findAll(@RequestParam(required = false) Map<String, Object> params){
        return restaurantService.findAll(params);
    }
}
