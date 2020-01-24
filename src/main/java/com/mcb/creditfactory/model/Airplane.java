package com.mcb.creditfactory.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "AIRPLANE")

public class Airplane {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String brand;
    private String model;
    private String manufacturer;

    @Column(name = "year_of_issue")
    private Short year;

    @Column(name = "fuelCapacity")
    private int fuelCapacity;

    private int seats;


//
//    id IDENTITY primary key,
//    brand VARCHAR2(150),
//    model VARCHAR2(200),
//    manufacturer VARCHAR2(500),
//    year_of_issue YEAR,
//    fuelCapacity INT,
//    seats INT

}
