package com.mcb.creditfactory.service.airplane;

import com.mcb.creditfactory.dto.AirplaneDto;
import com.mcb.creditfactory.external.CollateralObject;
import com.mcb.creditfactory.external.CollateralType;
import com.mcb.creditfactory.model.AirplaneCostEvaluation;
import com.mcb.creditfactory.model.CarCostEvaluation;
import com.mcb.creditfactory.repository.AirplaneCostEvaluationRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.Optional;
import java.util.stream.StreamSupport;

@Service
@AllArgsConstructor
public class AirplaneAdapter implements CollateralObject {
    private AirplaneDto airplaneDto;

    @Autowired
    private AirplaneCostEvaluationRepository airplaneCostEvaluationRepository;


    @Override
    public BigDecimal getValue() {

        Long id = airplaneDto.getId();
        Iterable<AirplaneCostEvaluation> allByAirplaneId = airplaneCostEvaluationRepository.findAllByAirplaneId(id);

        return StreamSupport.stream(allByAirplaneId.spliterator(), false)
                .max(Comparator.comparing(AirplaneCostEvaluation::getDate))
                .orElseThrow(IllegalArgumentException::new).getValue();
    }

    @Override
    public Short getYear() {
        return airplaneDto.getYear();
    }

    @Override
    public LocalDate getDate() {

        return StreamSupport.stream(airplaneCostEvaluationRepository
                .findAllByAirplaneId(airplaneDto.getId()).spliterator(), false)
                .max(Comparator.comparing(AirplaneCostEvaluation::getDate))
                .orElseThrow(IllegalArgumentException::new).getDate()
                .toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
    }

    @Override
    public CollateralType getType() {
        return CollateralType.AIRPLANE;
    }
}
