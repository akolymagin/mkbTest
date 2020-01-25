package com.mcb.creditfactory.service.airplane;

import com.mcb.creditfactory.dto.AirplaneDto;
import com.mcb.creditfactory.external.CollateralObject;
import com.mcb.creditfactory.external.CollateralType;
import com.mcb.creditfactory.model.AirplaneCostEvaluation;
import com.mcb.creditfactory.model.CarCostEvaluation;
import com.mcb.creditfactory.repository.AirplaneCostEvaluationRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;
import java.util.Iterator;
@Service
@AllArgsConstructor
public class AirplaneAdapter implements CollateralObject {
      private AirplaneDto airplaneDto;

      @Autowired
      private AirplaneCostEvaluationRepository airplaneCostEvaluationRepository;



    @Override
    public BigDecimal getValue() {

        Long id = airplaneDto.getId();
        Iterable<AirplaneCostEvaluation> allByAirplaneId = airplaneCostEvaluationRepository.findAllByAirplaneId(id);
        Iterator<AirplaneCostEvaluation> iterator = allByAirplaneId.iterator();
        Date lastDate = new Date(0);
        while (iterator.hasNext()){
            AirplaneCostEvaluation next = iterator.next();
            Date date = next.getDate();
            if(date.after(lastDate)){
                lastDate=date;
            }
        }
//        allByAirplaneId.spliterator();
        return null;
    }

    @Override
    public Short getYear() {
        return null;
    }

    @Override
    public LocalDate getDate() {
        return null;
    }

    @Override
    public CollateralType getType() {
        return null;
    }
}
