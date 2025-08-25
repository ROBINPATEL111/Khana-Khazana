package com.backend.Restro.controller;
import com.backend.Restro.entity.Restaurant;
import com.backend.Restro.services.RestaurantService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/restaurantlist")

public class RestaurantController {

    private  RestaurantService restaurantService;

    public RestaurantController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    @GetMapping
    public List<Restaurant> listRestaurants() {
        return restaurantService.getAllRestaurants();
    }
}
