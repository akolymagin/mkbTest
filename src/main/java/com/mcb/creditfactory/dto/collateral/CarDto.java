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
@JsonTypeName("car")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CarDto implements Collateral {
    public CarDto(Long id, String brand, String model, Double power, Short year) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.power = power;
        this.year = year;
    }

    private Long id;
    private String brand;
    private String model;
    private Double power;
    private Short year;
    private BigDecimal firstValue;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date dateOfFirstValue;
}
