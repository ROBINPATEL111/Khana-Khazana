package com.backend.Restro.services;

import com.backend.Restro.repository.BookingRepository;
import org.springframework.stereotype.Service;

@Service
public class BookingService {

    private BookingRepository bookingRepository;

    BookingService(BookingRepository bookingRepository)
    {
        this.bookingRepository = bookingRepository;
    }


}
