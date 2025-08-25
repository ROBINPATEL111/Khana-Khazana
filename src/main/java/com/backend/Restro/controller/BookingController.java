package com.backend.Restro.controller;

import com.backend.Restro.model.BookingRequest;
import com.backend.Restro.model.BookingResponse;
import com.backend.Restro.model.BookingStatus;
import com.backend.Restro.services.BookingService;
import com.sun.net.httpserver.Request;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/booking")
public class BookingController {

    private BookingService bookingService;

    BookingController(BookingService bookingService)
    {
        this.bookingService = bookingService;
    }

    @GetMapping("/read")
    public ResponseEntity<List<BookingResponse>>getAllBookings()
    {
        return new ResponseEntity<>(this.bookingService.getAllBooking(),HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<BookingResponse>createBooking(@RequestBody BookingRequest bookingRequest)
    {
        return new ResponseEntity<>(bookingService.createBooking(bookingRequest), HttpStatus.OK);
    }

    @PutMapping("update")
    public ResponseEntity<BookingResponse>updateBooking(@RequestBody BookingRequest bookingRequest)
    {
        return new ResponseEntity<>(bookingService.updateBooking(bookingRequest),HttpStatus.OK);
    }

    @DeleteMapping("/delete/{name}")
    public ResponseEntity<BookingResponse>deleteUserRegistration(@PathVariable String name)
    {
        return new ResponseEntity<>(this.bookingService.deleteBooking(name),HttpStatus.OK);
    }

    @GetMapping("/filter")
    public ResponseEntity<List<BookingResponse>> getBookingByDateAndStatus(@RequestParam String date , @RequestParam BookingStatus status)
    {
        return new ResponseEntity<>(bookingService.getBookingByDateAndStatus(date,status),HttpStatus.OK);
    }


}
