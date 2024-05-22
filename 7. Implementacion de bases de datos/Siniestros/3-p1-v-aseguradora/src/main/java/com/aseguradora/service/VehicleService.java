package com.aseguradora.service;

import com.aseguradora.entity.Vehicle;

import java.util.List;

public interface VehicleService {

    List<String> getAllVehiclesLicensePlates();

    List<Vehicle> getVehiclesLicensePlateAndBrandByYearFabrication();

    List<String> getLicensePlateByCarWithMoreThanFourWheelsFabricatedInCurrentYear();
}
