package com.mercadolibre.covid19.service;

import com.mercadolibre.covid19.model.dto.RiskPerson;

import java.util.List;

public interface IPersonService {
    List<RiskPerson> findRiskPerson();
}
