package com.mcb.creditfactory.service.car;

import com.mcb.creditfactory.dto.collateral.CarDto;
import com.mcb.creditfactory.external.CollateralObject;
import com.mcb.creditfactory.external.CollateralType;
import com.mcb.creditfactory.model.CarCostEvaluation;
import com.mcb.creditfactory.repository.CarCostEvaluationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.stream.StreamSupport;

@Service

public class CarAdapter implements CollateralObject {
    private CarDto car;

    public void setCar(CarDto car) {
        this.car = car;
    }

    @Autowired
    private CarCostEvaluationRepository carCostEvaluationRepository;

    @Override
    public BigDecimal getValue() {
        Long id = car.getId();
        Iterable<CarCostEvaluation> allByCarId = carCostEvaluationRepository.findAllByCarId(id);
        return StreamSupport.stream(allByCarId.spliterator(), false)
                .max(Comparator.comparing(CarCostEvaluation::getDate))
                .orElseThrow(IllegalArgumentException::new).getValue();
    }

    @Override
    public Short getYear() {
        return car.getYear();
    }

    @Override
    public LocalDate getDate() {
        // Для автомобилей дата оценки не используется, поэтому всегда берем текущую
        return LocalDate.now();
    }

    @Override
    public CollateralType getType() {
        return CollateralType.CAR;
    }
}
