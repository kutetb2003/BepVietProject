package com.bepviet.converter;

import com.bepviet.builder.RestaurantRequestBuilder;
import com.bepviet.utils.MapUtil;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class RestaurantBuilderConverter {
    public RestaurantRequestBuilder restaurantRequestBuilder(Map<String, Object> params){
        return RestaurantRequestBuilder.builder()
                .name(MapUtil.getObject(params, "name", String.class))
                .phoneNumber(MapUtil.getObject(params,"phoneNumber", String.class))
                .averageRating(MapUtil.getObject(params,"averageRating", Double.class))
                .managerName(MapUtil.getObject(params,"managerName", String.class))
                .build();
    }
}
