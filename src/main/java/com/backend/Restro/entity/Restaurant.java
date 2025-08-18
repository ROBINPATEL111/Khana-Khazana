package com.backend.Restro.entity;
import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalTime;

@Data
@Entity
@Table(name = "Restaurant")
public class Restaurant {
    @Id
    @SequenceGenerator(name = "Restaurant_id_seq" , sequenceName = "Restaurant_id_seq",allocationSize = 1, initialValue = 5)
    @GeneratedValue(strategy = GenerationType.SEQUENCE , generator ="Restaurant_id_seq" )

    @Column(name = "restro_id")
    private Integer restro_id;

    @Column(name="name")
    private String name;

    @Column(name = "address")
    private String address;

    @Column(name = "cuisine")
    private String cuisine;

    @Column(name = "open_time")
    private LocalTime open_time;

    @Column(name = "close_time")
    private LocalTime close_time;

    @Column(name = "no_of_table")
    private Integer no_of_table;


}
