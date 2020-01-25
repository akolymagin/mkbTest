package com.mcb.creditfactory.service.costEvaluation;

import com.mcb.creditfactory.dto.collateralCostEvaluation.CarCostEvaluationDto;
import com.mcb.creditfactory.model.CarCostEvaluation;
import org.springframework.stereotype.Service;


public interface CarCostEvaluationService {
    CarCostEvaluation save(CarCostEvaluation carCostEvaluation);
    CarCostEvaluation fromDto(CarCostEvaluationDto carCostEvaluationDto);
    Long getId(CarCostEvaluation carCostEvaluation);

}
