package com.bepviet.repository;

import com.bepviet.repository.entity.RestaurantEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RestaurantRepository extends CrudRepository<RestaurantEntity, Long> {
    List<RestaurantEntity> findDistinctByNameContainingIgnoreCaseOrPhoneNumberContainingOrAverageRatingGreaterThanEqual(String name, String phoneNumber, Double averageRating);
}
