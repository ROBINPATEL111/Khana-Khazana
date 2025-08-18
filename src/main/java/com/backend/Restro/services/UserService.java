package com.backend.Restro.services;

import com.backend.Restro.repository.BookingRepository;
import com.backend.Restro.repository.UserDetailRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private UserDetailRepository userDetailRepository;
    private BookingRepository bookingRepository;

    UserService(UserDetailRepository userDetailRepository , BookingRepository bookingRepository)
    {
      this.userDetailRepository = userDetailRepository;
      this.bookingRepository = bookingRepository;
    }
}
