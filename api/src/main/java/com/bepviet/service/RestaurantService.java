package com.bepviet.service;

import com.bepviet.dto.RestaurantDto;
import com.bepviet.dto.request.RestaurantRequest;

import java.util.List;
import java.util.Map;

public interface RestaurantService {
    List<RestaurantDto> findAll(Map<String, Object> params);
    void createNewRestaurant(RestaurantRequest restaurantRequest);
    void updateRestaurant(RestaurantRequest restaurantReques);
}
