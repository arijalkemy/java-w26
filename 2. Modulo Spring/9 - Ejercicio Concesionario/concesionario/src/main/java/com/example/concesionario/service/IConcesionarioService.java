package com.example.concesionario.service;

import com.example.concesionario.dto.VehiculoDTO;
import com.example.concesionario.entity.Vehiculo;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IConcesionarioService {

    public ResponseEntity<?> crearVehiculo(VehiculoDTO vehiculo);

    public ResponseEntity<?> buscarTodos();

    public ResponseEntity<?> buscarPorPrecio(double desde, double hasta);

    public ResponseEntity<?> buscarPorFecha(Integer desde, Integer hasta);

    public ResponseEntity<?> buscarPorId(Integer id);
}
