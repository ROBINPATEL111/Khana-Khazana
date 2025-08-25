package com.backend.Restro.model;

import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.Data;

@Data
public class BookingRequest {
    private String name;
    private String date;
    private String bookingTime;
    private Integer headCount;
}
