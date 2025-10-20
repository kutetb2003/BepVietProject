package com.bepviet.builder;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class RestaurantRequestBuilder {
    private String name;
    private String phoneNumber;
    private Double averageRating;
    private String managerName;
}
