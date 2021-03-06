package com.mcb.creditfactory.repository;

import com.mcb.creditfactory.model.AirplaneCostEvaluation;
import org.springframework.data.repository.CrudRepository;

public interface AirplaneCostEvaluationRepository extends CrudRepository<AirplaneCostEvaluation,Long> {
    Iterable<AirplaneCostEvaluation> findAllByAirplaneId(Long airplaneId);


}
