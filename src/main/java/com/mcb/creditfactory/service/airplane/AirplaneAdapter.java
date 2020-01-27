package com.mcb.creditfactory.service.airplane;

import com.mcb.creditfactory.dto.collateral.AirplaneDto;
import com.mcb.creditfactory.external.CollateralObject;
import com.mcb.creditfactory.external.CollateralType;
import com.mcb.creditfactory.model.AirplaneCostEvaluation;
import com.mcb.creditfactory.repository.AirplaneCostEvaluationRepository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Comparator;
import java.util.stream.StreamSupport;

@Service
@NoArgsConstructor
public class AirplaneAdapter implements CollateralObject {
    private AirplaneDto airplaneDto;

    public void setAirplaneDto(AirplaneDto airplaneDto) {
        this.airplaneDto = airplaneDto;
    }

    @Autowired
    private AirplaneCostEvaluationRepository airplaneCostEvaluationRepository;


    @Override
    public BigDecimal getValue() {

        Long id = airplaneDto.getId();
        Iterable<AirplaneCostEvaluation> allByAirplaneId = airplaneCostEvaluationRepository.findAllByAirplaneId(id);
        if (allByAirplaneId.iterator().hasNext()) {
            return StreamSupport.stream(allByAirplaneId.spliterator(), false)
                    .max(Comparator.comparing(AirplaneCostEvaluation::getDate))
                    .orElseThrow(IllegalArgumentException::new).getValue();
        }
        else return airplaneDto.getValue();
    }

    @Override
    public Short getYear() {
        return airplaneDto.getYear();
    }

    @Override
    public LocalDate getDate() {
        if (airplaneCostEvaluationRepository
                .findAllByAirplaneId(airplaneDto.getId())
                .iterator().hasNext()
        ) {
            return StreamSupport.stream(airplaneCostEvaluationRepository
                    .findAllByAirplaneId(airplaneDto.getId()).spliterator(), false)
                    .max(Comparator.comparing(AirplaneCostEvaluation::getDate))
                    .orElseThrow(IllegalArgumentException::new).getDate()
                    .toInstant()
                    .atZone(ZoneId.systemDefault())
                    .toLocalDate();
        }
        else {
            return airplaneDto.getDateOfFirstValue()
                    .toInstant()
                    .atZone(ZoneId.systemDefault())
                    .toLocalDate();
        }
    }

    @Override
    public CollateralType getType() {
        return CollateralType.AIRPLANE;
    }
}
