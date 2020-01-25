package com.mcb.creditfactory.service.costEvaluation;

import com.mcb.creditfactory.dto.collateralCostEvaluation.CarCostEvaluationDto;
import com.mcb.creditfactory.model.CarCostEvaluation;
import com.mcb.creditfactory.repository.CarCostEvaluationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarCostEvaluationServiceImpl implements CarCostEvaluationService {
    @Autowired
    CarCostEvaluationRepository carCostEvaluationRepository;

    @Override
    public CarCostEvaluation save(CarCostEvaluation carCostEvaluation) {
        return carCostEvaluationRepository.save(carCostEvaluation);
    }

    @Override
    public CarCostEvaluation fromDto(CarCostEvaluationDto carCostEvaluationDto) {
        return new CarCostEvaluation(
                carCostEvaluationDto.getId(),
                carCostEvaluationDto.getCarId(),
                carCostEvaluationDto.getValue(),
                carCostEvaluationDto.getDate()
        );
    }

    @Override
    public Long getId(CarCostEvaluation carCostEvaluation) {
        return carCostEvaluation.getId();
    }
}
