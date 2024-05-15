package com.meliBootcamp.restdto.servicies;

import com.meliBootcamp.restdto.servicies.interfaces.IAges;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
@Service
public class AgesIMP implements IAges {
    @Override
    public Integer betwenAges(Integer year, Integer month, Integer day) {
        return   Period.between(LocalDate.of(year,month,day),LocalDate.now()).getYears();
    }

}
