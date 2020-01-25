package com.mcb.creditfactory.service.costEvaluation;

import com.mcb.creditfactory.dto.collateralCostEvaluation.AirplaneCostEvaluationDto;
import com.mcb.creditfactory.model.AirplaneCostEvaluation;
import com.mcb.creditfactory.repository.AirplaneCostEvaluationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AirplaneCostEvaluationServiceImpl implements AirplaneCostEvaluationService{
    @Autowired
    AirplaneCostEvaluationRepository airplaneCostEvaluationRepository;

    @Override
    public AirplaneCostEvaluation save(AirplaneCostEvaluation airplaneCostEvaluation) {
        return airplaneCostEvaluationRepository.save(airplaneCostEvaluation);
    }

    @Override
    public AirplaneCostEvaluation fromDto(AirplaneCostEvaluationDto dto) {
        return new AirplaneCostEvaluation(dto.getId(),dto.getAirplaneId(),dto.getValue(),dto.getDate());
    }

    @Override
    public Long getId(AirplaneCostEvaluation airplaneCostEvaluation) {
        return airplaneCostEvaluation.getId();
    }

}
