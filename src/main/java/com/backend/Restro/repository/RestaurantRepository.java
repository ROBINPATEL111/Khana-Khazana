package com.backend.Restro.repository;

import com.backend.Restro.entity.Restaurant;
import com.backend.Restro.entity.UserDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Integer> {
}
