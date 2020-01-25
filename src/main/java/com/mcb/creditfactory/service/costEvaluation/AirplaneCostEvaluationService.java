package com.mcb.creditfactory.service.costEvaluation;

import com.mcb.creditfactory.dto.collateralCostEvaluation.AirplaneCostEvaluationDto;
import com.mcb.creditfactory.model.AirplaneCostEvaluation;

public interface AirplaneCostEvaluationService {
    AirplaneCostEvaluation save(AirplaneCostEvaluation airplaneCostEvaluation);
    AirplaneCostEvaluation fromDto(AirplaneCostEvaluationDto dto);
    Long getId(AirplaneCostEvaluation airplaneCostEvaluation);
}
