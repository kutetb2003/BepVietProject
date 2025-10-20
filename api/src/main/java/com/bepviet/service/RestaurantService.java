package com.bepviet.service;

import com.bepviet.dto.RestaurantDto;

import java.util.List;
import java.util.Map;

public interface RestaurantService {
    List<RestaurantDto> findAll(Map<String, Object> params);
}
