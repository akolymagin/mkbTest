package com.mcb.creditfactory.dto.collateralCostEvaluation;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = CarCostEvaluationDto.class),
        @JsonSubTypes.Type(value = AirplaneCostEvaluationDto.class)
})
public interface CostEvaluation {
}
