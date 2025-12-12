package com.bepviet.controller;

import com.bepviet.dto.RestaurantDto;
import com.bepviet.dto.request.RestaurantRequest;
import com.bepviet.service.RestaurantService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/restaurants/")
public class RestaurantController {
    private final RestaurantService restaurantService;
    public RestaurantController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    @GetMapping
    public List<RestaurantDto> findAll(@RequestParam(required = false) Map<String, Object> params) {
        return restaurantService.findAll(params);
    }
    @PostMapping
    public void addOrUpdateRestaurant(@RequestBody RestaurantRequest restaurantRequest){
        System.out.println("Dang o day");
        if(restaurantRequest.getId() == null){
            restaurantService.createNewRestaurant(restaurantRequest);
        }
        else{
            restaurantService.updateRestaurant(restaurantRequest);
        }
    }

    @DeleteMapping("{id}")
    public void deleteRestaurant(@PathVariable Long id){
        System.out.println("oke");
    }

}
