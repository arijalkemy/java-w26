package com.w26.covid19.service;

import com.w26.covid19.dto.FindPersonRiskResult;
import com.w26.covid19.dto.PersonRisk;
import com.w26.covid19.entity.PersonSymptom;
import com.w26.covid19.exception.NotFoundEntityException;
import com.w26.covid19.repository.PersonSymptomRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class FindPersonRisk implements IFindPersonRisk {

    final PersonSymptomRepository personSymptomRepository;

    public FindPersonRisk(PersonSymptomRepository personSymptomRepository) {
        this.personSymptomRepository = personSymptomRepository;
    }

    @Override
    public FindPersonRiskResult findPersonRisk() {
        List<PersonSymptom> personSymptomList = personSymptomRepository.getPersonSymptomList();
        List<PersonSymptom> optionalFilter = personSymptomList.stream().filter(personSymptom -> personSymptom.getPerson().getEdad() >= 60).toList();
        if (optionalFilter.isEmpty())
            throw new NotFoundEntityException("No se encontro ninguna persona mayor a 60 años y con algun sintoma de covid-19");
        List<PersonRisk> personRiskList = new ArrayList<>();

        for (PersonSymptom personSymptom: optionalFilter) {
            personRiskList.add(new PersonRisk(personSymptom.getPerson().getNombre(), personSymptom.getPerson().getApellido()) );

        }

        FindPersonRiskResult findPersonRiskResult = new FindPersonRiskResult("Se obtuvieron correctamente todos las personas con las condiciones establecidas", personRiskList);
        return findPersonRiskResult;

    }
}
