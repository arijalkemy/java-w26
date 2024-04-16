package org.example.api.services;

import org.example.api.entities.dto.RiskPersonDTO;

import java.util.List;

public interface IRiskPerson {
    List<RiskPersonDTO> findRiskPerson();
}
