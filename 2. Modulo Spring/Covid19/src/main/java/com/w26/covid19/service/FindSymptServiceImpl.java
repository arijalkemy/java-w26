package com.w26.covid19.service;

import com.w26.covid19.dto.FindAllSymptResult;
import com.w26.covid19.dto.FindSymptResult;
import com.w26.covid19.entity.Symptom;
import com.w26.covid19.exception.NotFoundEntityException;
import com.w26.covid19.repository.SymptomRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.cors.reactive.PreFlightRequestWebFilter;

import java.util.List;
import java.util.Optional;

@Service
public class FindSymptServiceImpl implements  IFindSymptService {
    final SymptomRepository symptomRepository;

    public FindSymptServiceImpl(SymptomRepository symptomRepository) {
        this.symptomRepository = symptomRepository;
    }

    @Override
    public FindAllSymptResult findAllSympt() {
        if (symptomRepository.getSymptomRepositoryList().isEmpty())
            throw new NotFoundEntityException("No se encontro ningun sintoma registrado en la bd");
        FindAllSymptResult result = new FindAllSymptResult(symptomRepository.getSymptomRepositoryList(), "Se encontraron los sintomas correctamente");
        return result;
    }

    @Override
    public FindSymptResult findByName(String name) {
        List<Symptom> listSymptomList = symptomRepository.getSymptomRepositoryList();
        Optional<Symptom> symptomOptional = listSymptomList.stream().filter(symptom1 -> symptom1.getName().equals(name)).findFirst();

        if (!symptomOptional.isPresent())
            throw new NotFoundEntityException("No se encontro ningun sintoma con el nombre: " + name);
        Symptom symptom = symptomOptional.get();
        FindSymptResult result = new FindSymptResult("Se encontro correctamente", symptom.getName(), symptom.getSeverity());
        return result;
    }
}
