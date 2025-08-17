package com.backend.Restro.repository;

import com.backend.Restro.entity.Booking;
import com.backend.Restro.entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Integer> {
}
