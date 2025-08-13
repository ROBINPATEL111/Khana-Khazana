package com.backend.Restro.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalTime;

@Entity
@Table(name = "Restaurant")
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer restro_id;
    private String name;
    private String address;
    private String cuisine;
    private LocalTime open_time;
    private LocalTime close_time;
    private Integer no_of_table;
}
