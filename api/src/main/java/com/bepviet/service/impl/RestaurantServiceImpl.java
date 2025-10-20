package com.bepviet.service.impl;

import com.bepviet.builder.RestaurantRequestBuilder;
import com.bepviet.converter.EntityToDtoConverter;
import com.bepviet.converter.RestaurantBuilderConverter;
import com.bepviet.dto.RestaurantDto;
import com.bepviet.dto.ReviewDto;
import com.bepviet.repository.RestaurantRepository;
import com.bepviet.repository.entity.ReviewEntity;
import com.bepviet.service.RestaurantService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class RestaurantServiceImpl implements RestaurantService {
    private final RestaurantRepository restaurantRepository;
    private final RestaurantBuilderConverter restaurantBuilderConverter;
    private final EntityToDtoConverter entityToDtoConverter;
    public RestaurantServiceImpl(RestaurantRepository restaurantRepository, RestaurantBuilderConverter restaurantBuilderConverter, EntityToDtoConverter entityToDtoConverter) {
        this.entityToDtoConverter = entityToDtoConverter;
        this.restaurantRepository = restaurantRepository;
        this.restaurantBuilderConverter= restaurantBuilderConverter;
    }

    public List<RestaurantDto> findAll(Map<String, Object> params) {
        List<RestaurantDto> res = new ArrayList<>();
        RestaurantRequestBuilder restaurantRequestBuilder = restaurantBuilderConverter.restaurantRequestBuilder(params);
        if(params.isEmpty()) {
            restaurantRepository.findAll().forEach(restaurantEntity -> {
                List<ReviewDto> reviewDtos = entityToDtoConverter.convertToDtoList(restaurantEntity.getReviewEntities(), ReviewDto.class);
                RestaurantDto restaurantDto = entityToDtoConverter.convertToDto(restaurantEntity, RestaurantDto.class);
                restaurantDto.setReviews(reviewDtos);
                res.add(restaurantDto);
            });
        }
        else {
            restaurantRepository.findDistinctByNameContainingIgnoreCaseOrPhoneNumberContainingOrAverageRatingGreaterThanEqual(
                    restaurantRequestBuilder.getName(),
                    restaurantRequestBuilder.getPhoneNumber(),
                    restaurantRequestBuilder.getAverageRating()
            ).forEach(restaurantEntity -> {
                List<ReviewDto> reviewDtos = entityToDtoConverter.convertToDtoList(restaurantEntity.getReviewEntities(), ReviewDto.class);
                RestaurantDto restaurantDto = entityToDtoConverter.convertToDto(restaurantEntity, RestaurantDto.class);
                restaurantDto.setReviews(reviewDtos);
                res.add(restaurantDto);
            });
        }
        return res;
    }
}
