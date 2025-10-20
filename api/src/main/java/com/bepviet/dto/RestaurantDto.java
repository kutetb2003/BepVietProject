package com.bepviet.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class RestaurantDto extends ContentDto {
    private String address;
    private String phoneNumber;
    private String managerName;
}
