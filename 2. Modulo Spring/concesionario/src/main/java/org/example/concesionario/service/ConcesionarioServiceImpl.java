package org.example.concesionario.service;

import org.example.concesionario.dto.ResponseVehiculeDTO;
import org.example.concesionario.entity.VehicleEntity;

import org.example.concesionario.repository.IConcesionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@Service
public class ConcesionarioServiceImpl implements IConcensionarioService{

    @Autowired
    IConcesionarioRepository concesionarioRepository;

    @Override
    public VehicleEntity nuevoAuto(VehicleEntity vehicle) {
         return concesionarioRepository.nuevoAuto(vehicle);
    }

    @Override
    public List<ResponseVehiculeDTO> todosVehiculos() {
        return concesionarioRepository.todosVehiculos();
    }

    @Override
    public List<ResponseVehiculeDTO> vehiculosPorFecha(LocalDate since, LocalDate to) {

        return concesionarioRepository.vehiculosPorFecha(since, to);
    }

    @Override
    public List<ResponseVehiculeDTO> vehiculosPorPrecio(double since, double to) {
        return concesionarioRepository.vehiculosPorPrecio(since, to);
    }

    @Override
    public List<ResponseVehiculeDTO> vehiculoPorId(UUID id) {
        return concesionarioRepository.vehiculoPorId(id);
    }
}
