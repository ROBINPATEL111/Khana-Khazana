package com.backend.Restro.services;

import com.backend.Restro.entity.Booking;
import com.backend.Restro.entity.UserDetail;
import com.backend.Restro.model.BookingRequest;
import com.backend.Restro.model.BookingResponse;
import com.backend.Restro.model.BookingStatus;
import com.backend.Restro.repository.BookingRepository;
import com.backend.Restro.repository.UserDetailRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class BookingService {
    private BookingRepository bookingRepository;
    private UserDetailRepository userDetailRepository;

    BookingService(BookingRepository bookingRepository, UserDetailRepository userDetailRepository) {
        this.bookingRepository = bookingRepository;
        this.userDetailRepository = userDetailRepository;
    }

    public BookingResponse createBooking(BookingRequest request) {
        try {
            UserDetail userDetail = userDetailRepository.findByName(request.getName());

            if (userDetail == null) {
                throw new RuntimeException("user not found" + request.getName());
            }

            Booking booking = Booking.builder()
                    .userDetail(userDetail)
                    .headCount(request.getHeadCount())
                    .bookingDate(LocalDate.parse(request.getDate(), DateTimeFormatter.ISO_LOCAL_DATE))
                    .bookingTime(LocalTime.parse(request.getBookingTime(), DateTimeFormatter.ISO_LOCAL_TIME))
                    .status(BookingStatus.CONFIRMED)
                    .build();

            bookingRepository.save(booking);

            return BookingResponse.builder()
                    .name(userDetail.getName())
                    .date(booking.getBookingDate().toString())
                    .bookingTime(booking.getBookingTime().toString())
                    .headCount(booking.getHeadCount())
                    .build();
        } catch (Exception E) {
            log.error("Error Creating Booking:" + E.getMessage());
            throw new RuntimeException("failed to create Booking"+E.getMessage());

        }
    }

    public BookingResponse updateBooking(BookingRequest request) {
        try {
            UserDetail userDetail = userDetailRepository.findByName(request.getName());
            if (userDetail == null) {
                throw new RuntimeException("User not found with name: " + request.getName());
            }

            Booking booking = bookingRepository.findByUserDetail(userDetail);
            if (booking == null) {
                throw new RuntimeException("Booking not found for user: " + request.getName());
            }

            booking.setHeadCount(request.getHeadCount());
            booking.setBookingDate(LocalDate.parse(request.getDate(), DateTimeFormatter.ISO_LOCAL_DATE));
            booking.setBookingTime(LocalTime.parse(request.getBookingTime(), DateTimeFormatter.ISO_LOCAL_TIME));
            booking.setStatus(BookingStatus.CONFIRMED);

            bookingRepository.save(booking);

            return BookingResponse.builder()
                    .name(userDetail.getName())
                    .date(booking.getBookingDate().toString())
                    .bookingTime(booking.getBookingTime().toString())
                    .headCount(booking.getHeadCount())
                    .build();

        } catch (Exception e) {
            log.error("Error updating booking: {}", e.getMessage(), e);
            throw new RuntimeException("Error while updating booking", e);
        }
    }


        public BookingResponse deleteBooking (String name){
            try {
                UserDetail userDetail = userDetailRepository.findByName(name);

                if (userDetail == null) {
                    throw new RuntimeException("Booking not found for user: " + name);
                }

                Booking booking = bookingRepository.findByUserDetail(userDetail);
                if(booking == null)
                {
                    throw new RuntimeException("No Booking found for user:"+name);
                }

                bookingRepository.delete(booking);


                return BookingResponse.builder()
                        .name(userDetail.getName())
                        .date(booking.getBookingDate().toString())
                        .bookingTime(booking.getBookingTime().toString())
                        .headCount(booking.getHeadCount())
                        .build();
            } catch (Exception E) {
                log.error("Error deleting booking: {}", E.getMessage());
                throw new RuntimeException("Error while deleting booking"+E.getMessage());
            }
        }

        public List<BookingResponse> getAllBooking()
        {
            List<Booking>bookings = bookingRepository.findAll();
            List<BookingResponse> responseList = new ArrayList<>();

            for(Booking booking:bookings)
            {
                BookingResponse response = BookingResponse.builder()
                        .name(booking.getUserDetail().getName())
                        .date(booking.getBookingDate().toString())
                        .bookingTime(booking.getBookingTime().toString())
                        .headCount(booking.getHeadCount())
                        .build();
                responseList.add(response);
            }
            return responseList;
        }


//    http://localhost:8080/booking/filter?date=2025-01-20&status=CONFIRMED
        public List<BookingResponse> getBookingByDateAndStatus(String date , BookingStatus status)
        {
            try{
                LocalDate bookinDate = LocalDate.parse(date,DateTimeFormatter.ISO_LOCAL_DATE);
                List<Booking>bookings = bookingRepository.findByBookingDateAndStatus(bookinDate,status);

                if(bookings.isEmpty())
                {
                    throw new RuntimeException("No booking found for Date" +date +"and status"+status);
                }
                List<BookingResponse>responseList = new ArrayList<>();
                for (Booking booking : bookings)
                {
                 BookingResponse response = BookingResponse.builder()
                         .name(booking.getUserDetail().getName())
                         .date(booking.getBookingDate().toString())
                         .headCount(booking.getHeadCount())
                         .build();
                 responseList.add(response);
                }
                return responseList;
            }catch (Exception E)
            {
                log.error("Error Fetching Booking:{}",E.getMessage());
                throw new RuntimeException("Failed to fetch booking:"+E.getMessage());
            }
        }


    }
