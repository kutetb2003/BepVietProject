package com.bepviet.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestaurantController {
    @GetMapping("/api/restaurant")
    public String test(){
        return "Hello world";
    }
}
