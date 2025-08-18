package com.backend.Restro.services;

import com.backend.Restro.repository.RestaurantRepository;
import org.springframework.stereotype.Service;

@Service
public class RestaurantService {
    private RestaurantRepository restaurantRepository;

    RestaurantService(RestaurantRepository restaurantRepository)
    {
        this.restaurantRepository = restaurantRepository;
    }


}
