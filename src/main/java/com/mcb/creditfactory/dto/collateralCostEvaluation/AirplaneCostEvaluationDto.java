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
@JsonTypeName("airplaneCostEvaluation")
public class AirplaneCostEvaluationDto implements CostEvaluation {
        private Long id;
        private Long airplaneId;
        private BigDecimal value;
        private Date date;

}
