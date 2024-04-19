package org.example.integradorconcessionaire.repository;

import lombok.Getter;
import lombok.Setter;
import org.example.integradorconcessionaire.dto.VehicleRequestDTO;

import org.example.integradorconcessionaire.dto.VehicleResponseDetailDTO;
import org.example.integradorconcessionaire.entity.Vehicle;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Setter
@Getter
@Repository
public class VehicleRepositoryImp implements IVehicleRepository <VehicleRequestDTO, VehicleResponseDetailDTO> {

    private List<Vehicle> vehicleRepository;


    public VehicleRepositoryImp(){
        vehicleRepository = new ArrayList<>();

    }

    @Override
    public String add(VehicleRequestDTO vehicleRequestDTO) {
        UUID newId = UUID.randomUUID();
        try {

            String date = vehicleRequestDTO.getManufacturingDate();
            String [] dateElements = date.split("-");
            int[] dateElementsValue = new int[]{
                    Integer.parseInt(dateElements[0]),
                    Integer.parseInt(dateElements[1]),
                    Integer.parseInt(dateElements[2]),
            };

            Vehicle newVehicle = new Vehicle(
                newId,
                vehicleRequestDTO.getBrand(),
                vehicleRequestDTO.getModel(),
                LocalDate.of(dateElementsValue[0], dateElementsValue[1], dateElementsValue[2]),
                vehicleRequestDTO.getNumberOfKilometers(),
                vehicleRequestDTO.getDoors(),
                vehicleRequestDTO.getPrice(),
                vehicleRequestDTO.getCurrency(),
                vehicleRequestDTO.getServices(),
                vehicleRequestDTO.getCountOfOwners()
            );

            vehicleRepository.add(newVehicle);

            return newId + " fue creado de manera exitosa!";

        } catch (Exception e) {
            return e.getMessage();
        }
    }

    @Override
    public VehicleResponseDetailDTO retreatInfo(UUID vehicleId) {

        VehicleResponseDetailDTO vehicleResponseDetailDTO = new VehicleResponseDetailDTO();

        for (Vehicle vehicle : vehicleRepository){
            if (vehicle.getVehicleId().equals(vehicleId)){

                vehicleResponseDetailDTO.setBrand(vehicle.getBrand());
                vehicleResponseDetailDTO.setModel(vehicle.getModel());
                vehicleResponseDetailDTO.setManufacturingDate(vehicle.getManufacturingDate());
                vehicleResponseDetailDTO.setNumberOfKilometers(vehicle.getNumberOfKilometers());
                vehicleResponseDetailDTO.setDoors(vehicle.getDoors());
                vehicleResponseDetailDTO.setPrice(vehicle.getPrice());
                vehicleResponseDetailDTO.setCurrency(vehicle.getCurrency());
                vehicleResponseDetailDTO.setVehicleServices(vehicle.getVehicleServices());
                vehicleResponseDetailDTO.setCountOfOwners(vehicle.getCountOfOwners());
            }
        }

        return vehicleResponseDetailDTO;
    }
}
