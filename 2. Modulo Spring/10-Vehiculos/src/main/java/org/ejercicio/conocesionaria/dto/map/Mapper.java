package org.ejercicio.conocesionaria.dto.map;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.ejercicio.conocesionaria.dto.VehicleRequestDTO;
import org.ejercicio.conocesionaria.dto.VehicleResponseDTO;
import org.ejercicio.conocesionaria.entity.Service;
import org.ejercicio.conocesionaria.entity.Vehicle;

import java.util.stream.Collectors;

public class Mapper {
    public static Vehicle mapRequestDTOToVehicle(VehicleRequestDTO vehicle) {
        ObjectMapper mapper = new ObjectMapper().registerModule(new JavaTimeModule());

        return new Vehicle(
                vehicle.getBrand(),
                vehicle.getModel(),
                vehicle.getManufacturingDate(),
                vehicle.getDoors(),
                vehicle.getPrice(),
                vehicle.getCurrency(),
                vehicle.getServices().stream().map(s-> mapper.convertValue(s, Service.class))
                        .collect(Collectors.toList()),
                vehicle.getCountOfOwners()

        );
    }

    public static VehicleResponseDTO mapVehicleToResponseDTO(Vehicle vehicle) {
        ObjectMapper mapper = new ObjectMapper().registerModule(new JavaTimeModule());

        return mapper.convertValue(vehicle, VehicleResponseDTO.class);
    }
}
