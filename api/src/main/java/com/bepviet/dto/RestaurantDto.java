package com.bepviet.dto;

import lombok.Data;

@Data
public class RestaurantDto {
    private String name;
    private String address;
    private String phoneNumber;
    private Double rating;
    private String managerName;
}
