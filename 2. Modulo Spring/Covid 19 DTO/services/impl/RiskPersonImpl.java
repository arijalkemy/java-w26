package org.example.api.services.impl;

import org.example.api.entities.dto.RiskPersonDTO;
import org.example.api.services.IRiskPerson;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Primary
public class RiskPersonImpl implements IRiskPerson {
    private final List<RiskPersonDTO> riskPerson;

    public RiskPersonImpl(@Qualifier("riskPerson") List<RiskPersonDTO> riskPerson) {
        this.riskPerson = riskPerson;
    }

    @Override
    public List<RiskPersonDTO> findRiskPerson() {
        return this.riskPerson.stream().filter(riskPerson -> riskPerson.getAge() > 60).toList();
    }
}
