package com.bootcampW22.EjercicioGlobal.service.interfaces;

import com.bootcampW22.EjercicioGlobal.dto.response.MessageResponse;
import com.bootcampW22.EjercicioGlobal.dto.response.VehicleResponse;
import com.bootcampW22.EjercicioGlobal.entity.Vehicle;
import com.bootcampW22.EjercicioGlobal.exception.NotFoundException;
import com.bootcampW22.EjercicioGlobal.exception.RequestMalFormedException;
import com.bootcampW22.EjercicioGlobal.repository.interfaces.IVehicleRepository;
import com.bootcampW22.EjercicioGlobal.service.implementation.IVehicleService;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class VehicleServiceImpl implements IVehicleService {

    private final IVehicleRepository vehicleRepository;

    @Override
    public List<VehicleResponse> searchAllVehicles() {
        ObjectMapper mapper = new ObjectMapper();
        List<Vehicle> vehicleList = vehicleRepository.findAll();
        if (vehicleList.isEmpty()) {
            throw new NotFoundException("No se encontró ningun auto en el sistema.");
        }
        return vehicleList.stream()
                .map(v -> mapper.convertValue(v, VehicleResponse.class))
                .collect(Collectors.toList());
    }

    @Override
    public MessageResponse updateVehicleMaxSpeed(int id, Double speed) {
        if(speed <= 0) 
            throw new RequestMalFormedException("La velocidad a que se busca setear debe ser mayor a 0");

        Vehicle toUpdate = vehicleRepository.findAll()
                                            .stream()
                                            .filter(vehicle -> vehicle.getId() == id)
                                            .findFirst()
                                            .orElseThrow(() -> new NotFoundException(String.format("No se encontro vehiculo con el ID [%d]", id)));  
        
        toUpdate.setMax_speed(speed.toString());

        vehicleRepository.save(toUpdate);
        return new MessageResponse("Velocidad del vehículo actualizada exitosamente");
    }
}
