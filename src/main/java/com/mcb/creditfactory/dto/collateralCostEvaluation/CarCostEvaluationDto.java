package com.mcb.creditfactory.dto.collateralCostEvaluation;

import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonTypeName("carCostEvaluation")
public class CarCostEvaluationDto implements CostEvaluation {
    private Long id;
    private Long carId;
    private BigDecimal value;
    private Date date;
}
