package com.bootcamp.vehiculo.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.bootcamp.vehiculo.dto.VehiculoDTO;
import com.bootcamp.vehiculo.mapper.VehiculoMapper;
import com.bootcamp.vehiculo.service.IVehiculoService;
import org.springframework.stereotype.Service;

import com.bootcamp.vehiculo.model.Siniestro;
import com.bootcamp.vehiculo.model.Vehiculo;
import com.bootcamp.vehiculo.repository.IVehiculoRepository;
import org.springframework.transaction.annotation.Transactional;

@Service
public class VehiculoService implements IVehiculoService {
    private final IVehiculoRepository vehiculoRepository;

    public VehiculoService(IVehiculoRepository vehiculoRepository) {
        this.vehiculoRepository = vehiculoRepository;
    }

    private Vehiculo DTOToVehiculo(VehiculoReqDTO vehiculoReqDTO) {
        return new Vehiculo(vehiculoReqDTO.getPatente(), vehiculoReqDTO.getMarca(), vehiculoReqDTO.getAnyoFabricacion(),
                vehiculoReqDTO.getCantidadRuedas(), vehiculoReqDTO.getModelo());
    }

    private Siniestro DTOToSiniestro(SiniestroReqDTO siniestroReqDTO) {
        return new Siniestro(siniestroReqDTO.getFechaSiniestro(), siniestroReqDTO.getPerdidaEconomica());
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
                vehiculoRepository.findOrderByAnioFabricacion());
    }

    @Override
    public List<String> getPatentesByCuatroRuedasYAnioCorriente() {
        return vehiculoRepository.findPatentesByCuatroRuedasAndAnioFabricacion();
    }

    // 4.- Listar la matrícula, marca y modelo de todos los vehículos que hayan
    // tenido un siniestro con pérdida mayor de 10000 pesos.
    @Override
    public VehiculoDTO getMatriculaMarcaModeloPerdidaMayorA(int i) {
        List<MatriculaMarcaModeloDTO> vehiculos = vehiculoRepository.findSiniestroMayorA(i).stream()
                .map(v -> new MatriculaMarcaModeloDTO(v.getPatente(), v.getMarca(), v.getModelo()))
                .toList();
        return new PerdidaMayorDTO(vehiculos);
    }

    // AUX.- Crear vehiculo:
    @Override
    public ResponseDTO postVehiculo(VehiculoReqDTO vehiculoReqDTO) {
        vehiculoRepository.save(DTOToVehiculo(vehiculoReqDTO));
        return new ResponseDTO("El Vehículo fue agregada correctamente");
    }

    // AUX.- Crear siniestro:
    @Override
    public ResponseDTO postSiniestro(Long vehiculoId, SiniestroReqDTO siniestroReqDTO) {
        Vehiculo vehiculo = vehiculoRepository.findById(vehiculoId).orElse(null);
        vehiculo.getSiniestros().add(DTOToSiniestro(siniestroReqDTO));
        vehiculoRepository.save(vehiculo);
        return new ResponseDTO("El siniestro fue agregada correctamente");
    }

}
