package com.example.concesionaria.service;

import com.example.concesionaria.dto.VehicleDetailDTO;
import com.example.concesionaria.dto.VehicleSummaryDTO;
import com.example.concesionaria.exception.VehicleNotFoundException;
import com.example.concesionaria.model.Vehicle;
import com.example.concesionaria.repository.IVehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VehicleServiceImpl implements IVehicleService {

    @Autowired
    IVehicleRepository iVehicleRepository;

    @Override
    public VehicleDetailDTO getAllVehicleById(Integer id) {
        
        Vehicle vehicle = iVehicleRepository.getVehicleById(id);
        if (vehicle == null ) throw new VehicleNotFoundException("El vehiculo con id: " + id + " no existe");

        VehicleDetailDTO vehicleDetailDTO = new VehicleDetailDTO();

        vehicleDetailDTO.setId(vehicle.getId());
        vehicleDetailDTO.setBrand(vehicle.getBrand());
        vehicleDetailDTO.setModel(vehicle.getModel());
        vehicleDetailDTO.setManufacturingDate(vehicle.getManufacturingDate());
        vehicleDetailDTO.setNumberOfKilometers(vehicle.getNumberOfKilometers());
        vehicleDetailDTO.setDoors(vehicle.getDoors());
        vehicleDetailDTO.setPrice(vehicle.getPrice());
        vehicleDetailDTO.setCurrency(vehicle.getCurrency());
        vehicleDetailDTO.setServices(vehicle.getServices());
        vehicleDetailDTO.setCountOfOwners(vehicle.getCountOfOwners());




        return vehicleDetailDTO;
    }

    @Override
    public Integer createVehicle(VehicleDetailDTO vehicleDetailDTO) {

        Vehicle vehicle = new Vehicle();


        vehicle.setBrand(vehicleDetailDTO.getBrand());
        vehicle.setModel(vehicleDetailDTO.getModel());
        vehicle.setManufacturingDate(vehicleDetailDTO.getManufacturingDate());
        vehicle.setNumberOfKilometers(vehicleDetailDTO.getNumberOfKilometers());
        vehicle.setDoors(vehicleDetailDTO.getDoors());
        vehicle.setPrice(vehicleDetailDTO.getPrice());
        vehicle.setCurrency(vehicleDetailDTO.getCurrency());
        vehicle.setServices(vehicleDetailDTO.getServices());
        vehicle.setCountOfOwners(vehicleDetailDTO.getCountOfOwners());

        return iVehicleRepository.createVehicle(vehicle);

    }


    @Override
    public List<VehicleSummaryDTO> getAllVehiclesSummary() {


        List<Vehicle> vehicleList = iVehicleRepository.getAllVehicles();

        List<VehicleSummaryDTO> vehicleSummaryDTOList = new ArrayList<>();



        for(Vehicle vehicle: vehicleList){

            VehicleSummaryDTO vehicleSummaryDTO = new VehicleSummaryDTO();

            vehicleSummaryDTO.setBrand(vehicle.getBrand());
            vehicleSummaryDTO.setModel(vehicle.getModel());
            vehicleSummaryDTO.setManufacturingDate(vehicle.getManufacturingDate());
            vehicleSummaryDTO.setNumberOfKilometers(vehicle.getNumberOfKilometers());
            vehicleSummaryDTO.setDoors(vehicle.getDoors());
            vehicleSummaryDTO.setPrice(vehicle.getPrice());
            vehicleSummaryDTO.setCurrency(vehicle.getCurrency());
            vehicleSummaryDTO.setCountOfOwners(vehicle.getCountOfOwners());

            vehicleSummaryDTOList.add(vehicleSummaryDTO);

        }

        return vehicleSummaryDTOList;
    }

    @Override
    public List<VehicleDetailDTO> getAllVehiclesByDate(Integer sinceDate, Integer toDate) {

        List<Vehicle> vehicleList = iVehicleRepository.getAllVehiclesByDate(sinceDate, toDate);

        List<VehicleDetailDTO> vehicleDetailDTOSList = new ArrayList<>();



        for(Vehicle vehicle: vehicleList){

            VehicleDetailDTO vehicleDetailDTO = new VehicleDetailDTO();

            vehicleDetailDTO.setBrand(vehicle.getBrand());
            vehicleDetailDTO.setModel(vehicle.getModel());
            vehicleDetailDTO.setManufacturingDate(vehicle.getManufacturingDate());
            vehicleDetailDTO.setNumberOfKilometers(vehicle.getNumberOfKilometers());
            vehicleDetailDTO.setDoors(vehicle.getDoors());
            vehicleDetailDTO.setPrice(vehicle.getPrice());
            vehicleDetailDTO.setCurrency(vehicle.getCurrency());
            vehicleDetailDTO.setServices(vehicle.getServices());
            vehicleDetailDTO.setCountOfOwners(vehicle.getCountOfOwners());

            vehicleDetailDTOSList.add(vehicleDetailDTO);

        }

        return vehicleDetailDTOSList;
    }

    @Override
    public List<VehicleDetailDTO> getAllVehiclesByPrice(Double sincePrice, Double toPrice) {
        List<Vehicle> vehicleList = iVehicleRepository.getAllVehiclesByPrice(sincePrice, toPrice);
        List<VehicleDetailDTO> vehicleDetailDTOSList = new ArrayList<>();
        for(Vehicle vehicle: vehicleList){
            VehicleDetailDTO vehicleDetailDTO = new VehicleDetailDTO();
            vehicleDetailDTO.setBrand(vehicle.getBrand());
            vehicleDetailDTO.setModel(vehicle.getModel());
            vehicleDetailDTO.setManufacturingDate(vehicle.getManufacturingDate());
            vehicleDetailDTO.setNumberOfKilometers(vehicle.getNumberOfKilometers());
            vehicleDetailDTO.setDoors(vehicle.getDoors());
            vehicleDetailDTO.setPrice(vehicle.getPrice());
            vehicleDetailDTO.setCurrency(vehicle.getCurrency());
            vehicleDetailDTO.setCountOfOwners(vehicle.getCountOfOwners());

            vehicleDetailDTOSList.add(vehicleDetailDTO);

        }

        return vehicleDetailDTOSList;
    }
}
