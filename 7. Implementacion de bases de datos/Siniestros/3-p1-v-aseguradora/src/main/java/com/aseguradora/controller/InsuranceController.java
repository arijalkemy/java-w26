package com.aseguradora.controller;

import com.aseguradora.entity.Accident;
import com.aseguradora.entity.Vehicle;
import com.aseguradora.repository.VehicleRepository;
import com.aseguradora.service.AccidentService;
import com.aseguradora.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class InsuranceController {

    @Autowired
    private VehicleService vehicleService;

    @Autowired
    private AccidentService accidentService;

    @GetMapping("/vehicles/allLicensePlates")
    public List<String> getAllLicensePlates() {
        return vehicleService.getAllVehiclesLicensePlates();
    }

    @GetMapping("/vehicles/licensePlatesAndBrandsByYear")
    public List<Vehicle> getLicensePlatesAndBrandsByYear() {
        return vehicleService.getVehiclesLicensePlateAndBrandByYearFabrication();
    }

    @GetMapping("/vehicles/licensePlatesByCarWithMoreThanFourWheels")
    public List<String> getLicensePlatesByCarWithMoreThanFourWheels() {
        return vehicleService.getLicensePlateByCarWithMoreThanFourWheelsFabricatedInCurrentYear();
    }

    @GetMapping("/accident/allEconomicLoss")
    public List<Accident> getAllEconomicLoss() {
        return accidentService.getAllEconomicLoss();
    }

    @GetMapping("/accident/economicLossByLicensePlate")
    public List<Accident> getEconomicLossByLicensePlate() {
        return accidentService.getAllEconomicLossByLicensePlate();
    }


}
