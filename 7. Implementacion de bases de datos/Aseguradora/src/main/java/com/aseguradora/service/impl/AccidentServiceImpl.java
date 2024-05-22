package com.aseguradora.service.impl;

import com.aseguradora.entity.Accident;
import com.aseguradora.repository.AccidentRepository;
import com.aseguradora.service.AccidentService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@NoArgsConstructor
@AllArgsConstructor
public class AccidentServiceImpl implements AccidentService {

    @Autowired
    private AccidentRepository accidentRepository;

    @Override
    public List<String> getAllEconomicLoss(){
        return accidentRepository.findAllEconomicLoss();
    }

    @Override
    public List<String> getAllEconomicLossByLicensePlate(){
        return accidentRepository.findAllEconomicLossByLicensePlate();
    }
}
