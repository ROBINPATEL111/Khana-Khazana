package com.backend.Restro.entity;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalTime;

@Data
@Entity
@Table(name = "Restaurant")
public class Restaurant {
    @Id
    @SequenceGenerator(name = "restaurant_id_seq", sequenceName = "restaurant_id_seq", allocationSize = 1, initialValue = 10)
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer restro_id;
    private String name;
    private String address;
    private String cuisine;
    private LocalTime openTime;
    private LocalTime closeTime;
    private Integer noOfTable;
}
