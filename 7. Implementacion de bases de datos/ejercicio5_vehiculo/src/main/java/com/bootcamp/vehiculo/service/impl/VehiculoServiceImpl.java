package com.bootcamp.vehiculo.service.impl;

import java.util.List;

import com.bootcamp.vehiculo.dto.ResponseDTO;
import com.bootcamp.vehiculo.dto.VehiculoDTO;
import com.bootcamp.vehiculo.exception.NotFoundException;
import com.bootcamp.vehiculo.mapper.VehiculoMapper;
import com.bootcamp.vehiculo.service.IVehiculoService;
import org.springframework.stereotype.Service;

import com.bootcamp.vehiculo.repository.IVehiculoRepository;
import org.springframework.transaction.annotation.Transactional;

@Service
public class VehiculoServiceImpl implements IVehiculoService {
    private final IVehiculoRepository vehiculoRepository;

    public VehiculoServiceImpl(IVehiculoRepository vehiculoRepository) {
        this.vehiculoRepository = vehiculoRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<String> getAllPatentes() {
        return vehiculoRepository.findAllPatentes();
    }

    @Override
    @Transactional(readOnly = true)
    public List<VehiculoDTO> getPatentesYMarcaOrdenadoPorAnio() {
        return VehiculoMapper.mapPatenteYMarcaALista(
                vehiculoRepository.findAllByOrderByAnioFabricacion());
    }

    @Override
    public List<String> getPatentesByCuatroRuedasYAnioCorriente() {
        return vehiculoRepository.findPatentesByCuatroRuedasAndAnioFabricacion();
    }

    @Override
    public List<VehiculoDTO> getMatriculaMarcaModeloPerdidaMayorA(int i) {
         return vehiculoRepository.findSiniestroMayorA(i).stream()
                .map(v -> VehiculoDTO.builder()
                        .patente(v.getPatente())
                        .marca(v.getMarca())
                        .modelo(v.getModelo()).build())
                 .toList();
    }

    @Override
    public ResponseDTO postVehiculo(VehiculoDTO vehiculoDTO) {
        vehiculoRepository.save(VehiculoMapper.vehiculoDTOToVehiculo(vehiculoDTO));
        return new ResponseDTO("El Vehículo fue agregada correctamente");
    }


    @Override
    @Transactional(readOnly = true)
    public VehiculoDTO findById(Long vehiculoId) {
        return VehiculoMapper.vehiculoToVehiculoDTO(
                vehiculoRepository.findById(vehiculoId).orElseThrow(() -> new NotFoundException("vehiculo")));

    }

}
