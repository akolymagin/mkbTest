package com.mcb.creditfactory.service.airplane;

import com.mcb.creditfactory.dto.AirplaneDto;
import com.mcb.creditfactory.external.CollateralObject;
import com.mcb.creditfactory.external.CollateralType;
import com.mcb.creditfactory.model.AirplaneCostEvaluation;
import com.mcb.creditfactory.model.CarCostEvaluation;
import lombok.AllArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Iterator;

@AllArgsConstructor
public class AirplaneAdapter implements CollateralObject {
      private AirplaneDto airplaneDto;


    @Override
    public BigDecimal getValue() {
        Long id = airplaneDto.getId();


        return null;
    }

    @Override
    public Short getYear() {
        return null;
    }

    @Override
    public LocalDate getDate() {
        return null;
    }

    @Override
    public CollateralType getType() {
        return null;
    }
}
