package com.example.concesionario.service;

import com.example.concesionario.dto.VehiculoDTO;
import com.example.concesionario.dto.VehiculoSinServiceDTO;
import com.example.concesionario.entity.Vehiculo;
import com.example.concesionario.repository.ConcesionarioRepository;
import com.example.concesionario.repository.IConcesionarioRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ConcesionarioService implements IConcesionarioService {

    @Autowired
    private ConcesionarioRepository _repository;

    @Autowired
    private ObjectMapper _mapper;

    public ResponseEntity<?> crearVehiculo(VehiculoDTO vehiculo){
        Vehiculo nuevoVehiculo = _mapper.convertValue(vehiculo, Vehiculo.class);
        Integer result = _repository.crearVehiculo(nuevoVehiculo);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<?> buscarTodos() {
        List<VehiculoSinServiceDTO> vehiculoDTOList = new ArrayList<>();
        for (Vehiculo v : _repository.buscarTodos()){
            vehiculoDTOList.add(_mapper.convertValue(v, VehiculoSinServiceDTO.class));
        }
        return new ResponseEntity<>(vehiculoDTOList, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> buscarPorPrecio(double desde, double hasta) {
        List<VehiculoSinServiceDTO> vehiculoDTOList = new ArrayList<>();
        for (Vehiculo v : _repository.buscarPorPrecio(desde, hasta)){
            vehiculoDTOList.add(_mapper.convertValue(v, VehiculoSinServiceDTO.class));
        }
        return new ResponseEntity<>(vehiculoDTOList, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> buscarPorFecha(Integer desde, Integer hasta) {
        List<VehiculoSinServiceDTO> vehiculoDTOList = new ArrayList<>();
        for (Vehiculo v : _repository.buscarPorFecha(desde, hasta)){
            vehiculoDTOList.add(_mapper.convertValue(v, VehiculoSinServiceDTO.class));
        }
        return new ResponseEntity<>(vehiculoDTOList, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> buscarPorId(Integer id) {
        return new ResponseEntity<>(_mapper.convertValue(_repository.buscarPorId(id),VehiculoDTO.class), HttpStatus.OK);
    }
}
