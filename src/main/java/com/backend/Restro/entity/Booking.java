package com.backend.Restro.entity;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Entity
@Table(name = "Booking")
public class Booking {

    @Id
    @SequenceGenerator(name = "booking_id_seq" , sequenceName ="booking_id_seq", allocationSize = 1 , initialValue = 5)
    @GeneratedValue(strategy = GenerationType.SEQUENCE ,generator = "booking_id_seq")


    @Column(name = "booking_id")
   private Integer booking_id;

    @ManyToOne
    @JoinColumn(name = "restro_id_fk",referencedColumnName = "restro_id")
   private Restaurant restaurant;

    @ManyToOne
    @JoinColumn(name = "user_id_fk" , referencedColumnName = "user_id")
   private UserDetail user;

    @ManyToOne
    @JoinColumn(name = "table_id_fk" ,referencedColumnName = "table_id")
   private Tables table;

    @Column(name = "booking_date")
    private LocalDate booking_date;


    @Column(name = "status")
   private String status;

    @Column(name = "people")
   private Integer people;
}
