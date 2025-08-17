package com.backend.Restro.entity;


import jakarta.persistence.*;
import java.time.LocalTime;

@Entity
@Table(name = "Booking")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Integer booking_id;
   private Integer restro_id;
   private Integer user_id ;
   private Integer table_id;
   private LocalTime open_time;
   private LocalTime close_time ;
   private String status;
   private Integer people;
}
