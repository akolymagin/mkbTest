package com.mcb.creditfactory.repository;

import com.mcb.creditfactory.model.CarCostEvaluation;
import org.springframework.data.repository.CrudRepository;

public interface CarCostEvaluationRepository extends CrudRepository<CarCostEvaluation,Long> {
    Iterable<CarCostEvaluation> findAllByCarId(Long carId);


}
