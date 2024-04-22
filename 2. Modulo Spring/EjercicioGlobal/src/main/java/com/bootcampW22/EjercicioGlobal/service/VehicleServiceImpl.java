package com.bootcampW22.EjercicioGlobal.service;

import com.bootcampW22.EjercicioGlobal.dto.ResponseCreateVehicleDTO;
import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import com.bootcampW22.EjercicioGlobal.entity.Vehicle;
import com.bootcampW22.EjercicioGlobal.exception.ConflictException;
import com.bootcampW22.EjercicioGlobal.exception.MatiExceptionTest;
import com.bootcampW22.EjercicioGlobal.exception.NotFoundException;
import com.bootcampW22.EjercicioGlobal.repository.IVehicleRepository;
import com.bootcampW22.EjercicioGlobal.repository.VehicleRepositoryImpl;
import com.bootcampW22.EjercicioGlobal.utils.Util;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class VehicleServiceImpl implements IVehicleService {

    IVehicleRepository vehicleRepository;

    public VehicleServiceImpl(VehicleRepositoryImpl vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    @Override
    public List<VehicleDto> searchAllVehicles() {
        ObjectMapper mapper = new ObjectMapper();
        List<Vehicle> vehicleList = vehicleRepository.findAll();
        if (vehicleList.isEmpty()) {
            throw new MatiExceptionTest("No se encontró ningun auto en el sistema.");
        }
        return vehicleList.stream()
                .map(v -> mapper.convertValue(v, VehicleDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public ResponseCreateVehicleDTO createVehicle(VehicleDto vehicle) {

        if (Util.tieneCampoNuloVehicle(vehicle)) {
            throw new MatiExceptionTest("Formatos mal formados");
        }

        Optional<Vehicle> vehicleExist = vehicleRepository.findOne(vehicle.getId());

        if (vehicleExist.isPresent()) {
            throw new ConflictException("Identificador de vehiculo ya existente");
        }

        ObjectMapper mapper = new ObjectMapper();

        Vehicle vehicleEntity = mapper.convertValue(vehicle, Vehicle.class);

        vehicleRepository.createVehicle(vehicleEntity);
        return new ResponseCreateVehicleDTO("Vehiculo creado exitosamente");
    }

    @Override
    public List<VehicleDto> searchVehiclesColorYear(String color, int year) {
        List<Vehicle> vehicleList = vehicleRepository.findByColorYear(color, year);
        if (vehicleList.size() == 0) {
            throw new NotFoundException("No se encontraron vehiculos con esos criterios");
        }

        ObjectMapper mapper = new ObjectMapper();

        return vehicleList.stream()
                .map(v -> mapper.convertValue(v, VehicleDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public ResponseCreateVehicleDTO updateFuel(VehicleDto vehicle, Long id) {
        ObjectMapper mapper = new ObjectMapper();
        Vehicle vehcileEntity = mapper.convertValue(vehicle,Vehicle.class);
        Vehicle vehicleResponse = vehicleRepository.updateFuel(vehcileEntity,id);
        if(vehicleResponse == null)
        {
            throw new NotFoundException("No se encontro el vehiculo");
        }
        return new ResponseCreateVehicleDTO("Tipo de combustible Actualizado exitosamente");
    }
}
