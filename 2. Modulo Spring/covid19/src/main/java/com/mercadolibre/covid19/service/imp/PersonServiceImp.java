package com.mercadolibre.covid19.service.imp;

import com.mercadolibre.covid19.model.dto.RiskPerson;
import com.mercadolibre.covid19.model.entity.Symptom;
import com.mercadolibre.covid19.repository.MockRepository;
import com.mercadolibre.covid19.service.IPersonService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServiceImp implements IPersonService {
    @Override
    public List<RiskPerson> findRiskPerson() {
        return MockRepository.people.stream()
                .filter(p -> p.getAge() > 60 && !p.getSymptoms().isEmpty())
                .map(p -> new RiskPerson(
                        p.getName(),
                        p.getLastName(),
                        p.getSymptoms().stream()
                                .map(Symptom::getName)
                                .toList()
                ))
                .toList();
    }
}
