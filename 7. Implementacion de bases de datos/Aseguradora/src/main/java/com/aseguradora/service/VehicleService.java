package com.aseguradora.service;

import com.aseguradora.entity.Vehicle;

import java.util.List;

public interface VehicleService {

    List<String> getAllVehiclesLicensePlates();

    List<String> getVehiclesLicensePlateAndBrandByYearFabrication();

    //List<String> getLicensePlateByCarWithMoreThanFourWheelsFabricatedInCurrentYear();
}
