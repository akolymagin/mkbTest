package com.mcb.creditfactory.service;

import com.mcb.creditfactory.dto.collateral.AirplaneDto;
import com.mcb.creditfactory.dto.collateral.CarDto;
import com.mcb.creditfactory.dto.collateral.Collateral;
import com.mcb.creditfactory.dto.collateralCostEvaluation.AirplaneCostEvaluationDto;
import com.mcb.creditfactory.dto.collateralCostEvaluation.CarCostEvaluationDto;
import com.mcb.creditfactory.dto.collateralCostEvaluation.CostEvaluation;
import com.mcb.creditfactory.model.CarCostEvaluation;
import com.mcb.creditfactory.service.airplane.AirplaneService;
import com.mcb.creditfactory.service.car.CarService;
import com.mcb.creditfactory.service.costEvaluation.AirplaneCostEvaluationService;
import com.mcb.creditfactory.service.costEvaluation.CarCostEvaluationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

// TODO: reimplement this
@Service
public class CollateralService {
    @Autowired
    private CarCostEvaluationService carCostEvaluationService;
    @Autowired
    private AirplaneCostEvaluationService airplaneCostEvaluationService;
    @Autowired
    private CarService carService;

    @Autowired
    private AirplaneService airplaneService;

    @SuppressWarnings("ConstantConditions")
    public Long saveCollateral(Collateral object) {
        if (!(object instanceof CarDto) & !(object instanceof AirplaneDto)) {
            throw new IllegalArgumentException();
        }

        if (object instanceof CarDto) {
            CarDto car = (CarDto) object;
            boolean approved = carService.approve(car);
            if (!approved) {
                return null;
            }
            Long result = Optional.of(car)
                    .map(carService::fromDto)
                    .map(carService::save)
                    .map(carService::getId)
                    .orElse(null);

            CarCostEvaluation costEvaluation = new CarCostEvaluation();
            costEvaluation.setCarId(car.getId());
            costEvaluation.setValue(car.getFirstValue());
            costEvaluation.setDate(car.getDateOfFirstValue());
            Optional.of(costEvaluation)
                    .map(carCostEvaluationService::save)
                    .orElseThrow(IllegalArgumentException::new);

            return result;
        }

        if (object instanceof AirplaneDto) {
            AirplaneDto airplaneDto = (AirplaneDto) object;
            boolean approved = airplaneService.approve(airplaneDto);
            if (!approved) {
                return null;                                                                     
            }


            return Optional.of(airplaneDto)
                    .map(airplaneService::fromDto)
                    .map(airplaneService::save)
                    .map(airplaneService::getId)
                    .orElse(null);
        }

        return null;
    }

    public Collateral getInfo(Collateral object) {
        if (!(object instanceof CarDto) & !(object instanceof AirplaneDto)) {
            throw new IllegalArgumentException();
        }

        if (object instanceof CarDto) {
            return Optional.of((CarDto) object)
                    .map(carService::fromDto)
                    .map(carService::getId)
                    .flatMap(carService::load)
                    .map(carService::toDTO)
                    .orElse(null);
        }
        if (object instanceof AirplaneDto) {
            return Optional.of((AirplaneDto) object)
                    .map(airplaneService::fromDto)
                    .map(airplaneService::getId)
                    .flatMap(airplaneService::load)
                    .map(airplaneService::toDTO)
                    .orElse(null);
        }

        return null;
    }

    public Long addCostEvaluation(CostEvaluation object){
        if (!(object instanceof CarCostEvaluationDto) & !(object instanceof AirplaneCostEvaluationDto)) {
            throw new IllegalArgumentException();
        }

        if (object instanceof CarCostEvaluationDto){

            return Optional.of((CarCostEvaluationDto) object)
                    .map(carCostEvaluationService::fromDto)
                    .map(carCostEvaluationService::save)
                    .map(carCostEvaluationService::getId)
                    .orElse(null);

        }

        if (object instanceof AirplaneCostEvaluationDto){
            return Optional.of((AirplaneCostEvaluationDto) object)
                    .map(airplaneCostEvaluationService::fromDto)
                    .map(airplaneCostEvaluationService::save)
                    .map(airplaneCostEvaluationService::getId)
                    .orElse(null);
        }
        return null;
    }

    

}
