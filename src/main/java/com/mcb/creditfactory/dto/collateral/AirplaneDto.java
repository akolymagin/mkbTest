package com.mcb.creditfactory.dto.collateral;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonTypeName("airplane")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AirplaneDto implements Collateral {
    public AirplaneDto(Long id, String brand, String model, String manufacturer, Short year, Double capacity, Long seats) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.manufacturer = manufacturer;
        this.year = year;
        this.capacity = capacity;
        this.seats = seats;
    }

    private Long id;
    private String brand;
    private String model;
    private String manufacturer;
    private Short year;
    private Double capacity;
    private Long seats;
    private BigDecimal firstValue;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date dateOfFirstValue;

}
