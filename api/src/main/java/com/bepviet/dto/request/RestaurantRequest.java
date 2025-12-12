package com.bepviet.dto.request;

import lombok.Data;

@Data
public class RestaurantRequest {
    private Long id;
    private String name;
    private String address;
    private String phoneNumber;
    private String description;
}
