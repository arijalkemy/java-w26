package com.spring.covid19.services;

import com.spring.covid19.dtos.RiskPersonDTO;

import java.util.List;

public interface IPersonService {
    List<RiskPersonDTO> findRiskPersons();

}
