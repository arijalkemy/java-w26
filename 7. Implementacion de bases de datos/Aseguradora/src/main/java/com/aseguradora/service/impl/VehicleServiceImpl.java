package com.aseguradora.service.impl;

import com.aseguradora.entity.Vehicle;
import com.aseguradora.repository.VehicleRepository;
import com.aseguradora.service.VehicleService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@NoArgsConstructor
@AllArgsConstructor
public class VehicleServiceImpl implements VehicleService {

    @Autowired
    private VehicleRepository vehicleRepository;

    @Override
    public List<String> getAllVehiclesLicensePlates(){
        return vehicleRepository.findAllVehiclesLicensePlates();
    }

    @Override
    public List<String> getVehiclesLicensePlateAndBrandByYearFabrication(){
        return vehicleRepository.findVehiclesLicensePlateAndBrandByYearFabrication();
    }

    /*@Override
    public List<String> getLicensePlateByCarWithMoreThanFourWheelsFabricatedInCurrentYear(){
        return vehicleRepository.findLicensePlateByCarWithMoreThanFourWheelsFabricatedInCurrentYear();
    }*/

}
