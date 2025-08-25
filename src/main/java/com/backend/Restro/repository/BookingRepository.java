package com.backend.Restro.repository;

import com.backend.Restro.entity.Booking;
import com.backend.Restro.entity.UserDetail;
import com.backend.Restro.model.BookingStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Integer> {


Booking findByUserDetail(UserDetail userDetail);

List<Booking> findByBookingDateAndStatus (LocalDate bookingDate , BookingStatus status);

}
