package org.example.concesionario.repository;


import org.example.concesionario.dto.ResponseVehiculeDTO;
import org.example.concesionario.entity.VehicleEntity;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository
public class ConcesionarioRepositoryImpl implements IConcesionarioRepository{
    List<VehicleEntity> vehicleEntityList = new ArrayList<>();
    @Override
    public VehicleEntity nuevoAuto(VehicleEntity vehicle) {
        vehicleEntityList.add(vehicle);
        return vehicle;
    }

    @Override
    public List<ResponseVehiculeDTO> todosVehiculos() {
        List<ResponseVehiculeDTO> responseVehiculeDTOList = new ArrayList<>();
        vehicleEntityList.stream().forEach(vehicleEntity -> {
            responseVehiculeDTOList.add(new ResponseVehiculeDTO(vehicleEntity.getBrand(), vehicleEntity.getModel(), vehicleEntity.getManufacturingDate(), vehicleEntity.getNumberOfKm(), vehicleEntity.getDoors(), vehicleEntity.getPrice(),
                    vehicleEntity.getCurrency(), vehicleEntity.getCountOfOwners()));
        });
        return responseVehiculeDTOList;
    }

    @Override
    public List<ResponseVehiculeDTO> vehiculosPorFecha(LocalDate since, LocalDate to) {
        List<ResponseVehiculeDTO> responseVehiculeDTOList = new ArrayList<>();

        List<VehicleEntity> vehicleFilterDate = vehicleEntityList.stream()
                .filter(vehicleEntity -> vehicleEntity.getManufacturingDate().isAfter(since) &&
                        vehicleEntity.getManufacturingDate().isBefore(to)).toList();

        vehicleFilterDate.stream().forEach(vehicleEntity -> {
            responseVehiculeDTOList.add(new ResponseVehiculeDTO(vehicleEntity.getBrand(),
                    vehicleEntity.getModel(), vehicleEntity.getManufacturingDate(),
                    vehicleEntity.getNumberOfKm(), vehicleEntity.getDoors(), vehicleEntity.getPrice(),
                    vehicleEntity.getCurrency(), vehicleEntity.getCountOfOwners()));
        });

        return responseVehiculeDTOList;
    }

    @Override
    public List<ResponseVehiculeDTO> vehiculosPorPrecio(double since, double to) {
        List<ResponseVehiculeDTO> responseVehiculeDTOList = new ArrayList<>();

        List<VehicleEntity> vehicleFilterPrice = vehicleEntityList.stream()
                .filter(vehicleEntity -> vehicleEntity.getPrice()>= since && vehicleEntity.getPrice()<=to).toList();

        vehicleFilterPrice.stream().forEach(vehicleEntity -> {
            responseVehiculeDTOList.add(new ResponseVehiculeDTO(vehicleEntity.getBrand(),
                    vehicleEntity.getModel(), vehicleEntity.getManufacturingDate(),
                    vehicleEntity.getNumberOfKm(), vehicleEntity.getDoors(), vehicleEntity.getPrice(),
                    vehicleEntity.getCurrency(), vehicleEntity.getCountOfOwners()));
        });
        return responseVehiculeDTOList;
    }

    @Override
    public List<ResponseVehiculeDTO> vehiculoPorId(UUID id) {
        List<ResponseVehiculeDTO> responseVehiculeDTOList = new ArrayList<>();

        List<VehicleEntity> vehicleById= vehicleEntityList.stream()
                .filter(vehicleEntity -> vehicleEntity.getId().equals(id)).toList();

        vehicleById.stream().forEach(vehicleEntity -> {
            responseVehiculeDTOList.add(new ResponseVehiculeDTO(vehicleEntity.getBrand(), vehicleEntity.getModel(), vehicleEntity.getManufacturingDate(), vehicleEntity.getNumberOfKm(), vehicleEntity.getDoors(), vehicleEntity.getPrice(),
                    vehicleEntity.getCurrency(), vehicleEntity.getCountOfOwners()));
        });
        return responseVehiculeDTOList;
    }
}
