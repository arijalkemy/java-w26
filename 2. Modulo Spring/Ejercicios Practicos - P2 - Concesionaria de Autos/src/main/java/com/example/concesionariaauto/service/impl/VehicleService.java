package com.example.concesionariaauto.service.impl;

import com.example.concesionariaauto.dto.VehicleAllResponseDTO;
import com.example.concesionariaauto.dto.VehicleRequestDTO;
import com.example.concesionariaauto.dto.VehicleResponseDTO;
import com.example.concesionariaauto.entity.VehicleEntity;
import com.example.concesionariaauto.repository.IVehilcesRepository;
import com.example.concesionariaauto.service.IVehicleService;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class VehicleService implements IVehicleService {
    private final ObjectMapper objectMapper;

    @Autowired
    IVehilcesRepository vehilcesRepository;

    public VehicleService() {
        objectMapper = new ObjectMapper();
        objectMapper.findAndRegisterModules();
    }

    @Override
    public VehicleResponseDTO addVehicle(VehicleRequestDTO vehicle) {
        VehicleEntity vehicleEntity = objectMapper.convertValue(vehicle, VehicleEntity.class);
        VehicleEntity newVehicle = vehilcesRepository.addVehicle(vehicleEntity);

        return objectMapper.convertValue(newVehicle, VehicleResponseDTO.class);
    }

    @Override
    public List<VehicleResponseDTO> listVehicle() {
        List<VehicleEntity> listAllVehicles = vehilcesRepository.listVehicles();

        // Convertimos la lista a JSON para poder mappear a List<VehicleResponseDTO>
        String json = null;

        try {
            json = objectMapper.writeValueAsString(listAllVehicles);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Error al convertir la lista de vehiculos a JSON");
        }

        // List<VehicleEntity> -> List<VehicleResponseDTO>
        TypeReference<List<VehicleResponseDTO>> typeRef = new TypeReference<>() {};
        List<VehicleResponseDTO> vehicleResponseDTO;

        try {
            vehicleResponseDTO = objectMapper.readValue(json, typeRef);
        } catch (IOException e) {
            throw new RuntimeException("Error al convertir JSON a lista de lista de Response DTOs");
        }

        return vehicleResponseDTO;
    }

    @Override
    public List<VehicleResponseDTO> listVehicleFromManufacturingDate(LocalDate since, LocalDate to) {
        List<VehicleEntity> vehiclesList = vehilcesRepository.listDateVehicles(since, to);

        // Convertimos la lista a JSON para poder mappear a List<VehicleResponseDTO>
        String json = null;

        try {
            json = objectMapper.writeValueAsString(vehiclesList);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Error al convertir la lista de vehiculos a JSON");
        }

        // List<VehicleEntity> -> List<VehicleResponseDTO>
        TypeReference<List<VehicleResponseDTO>> typeRef = new TypeReference<>() {};
        List<VehicleResponseDTO> vehicleResponseDTO;

        try {
            vehicleResponseDTO = objectMapper.readValue(json, typeRef);
        } catch (IOException e) {
            throw new RuntimeException("Error al convertir JSON a lista de lista de Response DTOs");
        }

        return vehicleResponseDTO;
    }

    @Override
    public List<VehicleResponseDTO> listVehicleFromPrice(int since, int to) {
        List<VehicleEntity> vehiclesList = vehilcesRepository.listPriceVehicles(since, to);

        // Convertimos la lista a JSON para poder mappear a List<VehicleResponseDTO>
        String json = null;

        try {
            json = objectMapper.writeValueAsString(vehiclesList);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Error al convertir la lista de vehiculos a JSON");
        }

        // List<VehicleEntity> -> List<VehicleResponseDTO>
        TypeReference<List<VehicleResponseDTO>> typeRef = new TypeReference<>() {};
        List<VehicleResponseDTO> vehicleResponseDTO;

        try {
            vehicleResponseDTO = objectMapper.readValue(json, typeRef);
        } catch (IOException e) {
            throw new RuntimeException("Error al convertir JSON a lista de lista de Response DTOs");
        }

        return vehicleResponseDTO;
    }

    @Override
    public VehicleAllResponseDTO getVehicleById(UUID id) {
        VehicleEntity vehicleEntity = vehilcesRepository.getVehicleById(id);
        if(vehicleEntity == null) {
            throw  new RuntimeException("Vehículo no encontrado");
        }

        return objectMapper.convertValue(vehicleEntity, VehicleAllResponseDTO.class);
    }

}
