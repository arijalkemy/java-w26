package com.aseguradora.service;

import com.aseguradora.entity.Accident;

import java.util.List;

public interface AccidentService {

    List<String> getAllEconomicLoss();

    List<String> getAllEconomicLossByLicensePlate();
}
