package org.example.vehiculos.service.impl;

import org.example.vehiculos.dto.VehiculoDTO;
import org.example.vehiculos.dto.VehiculoSiniestro;
import org.example.vehiculos.dto.VehiculoSiniestroDTO;
import org.example.vehiculos.entity.Vehiculo;
import org.example.vehiculos.repository.IVehiculoRepository;
import org.example.vehiculos.service.IVehiculoService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehiculoService implements IVehiculoService {

    private final IVehiculoRepository vehiculoRepository;
    private final ModelMapper modelMapper;

    public VehiculoService(IVehiculoRepository vehiculoRepository) {
        this.vehiculoRepository = vehiculoRepository;
        this.modelMapper = new ModelMapper();
    }

    @Override
    public List<String> listarTodasLasPatentes() {
        return vehiculoRepository.listarTodasLasPatentes().stream()
                .toList();
    }

    @Override
    public List<VehiculoDTO> listarPatentesYMarcaOrdenadoPorAnio() {
        return vehiculoRepository.findByOrderByAnioDeFabricacionAsc().stream()
                .map( v -> {
                    v.setModelo(null);
                    return modelMapper.map(v, VehiculoDTO.class);
                })
                .toList();
    }

    @Override
    public List<String> listarPatentesConMasDeCuatroRuedasFabricadosEsteAnio() {
        return vehiculoRepository.listarPatentesConMasDeCuatroRuedasFabricadosEsteAnio().stream()
                .toList();
    }

    @Override
    public List<VehiculoDTO> listarMatriculaMarcaYModeloConSiniestroMayor() {
        return vehiculoRepository.listarMatriculaMarcaYModeloConSiniestroMayor().stream()
                .map(this::convertToDto)
                .toList();
    }

    @Override
    public List<VehiculoSiniestroDTO> listarMatriculaMarcaModeloYPerdidaTotalConSiniestroMayor() {
        return vehiculoRepository.listarMatriculaMarcaModeloYPerdidaTotalConSiniestroMayor().stream()
                .map(this::convertToDTOVehiculoSiniestro)
                .toList();

    }

    private VehiculoDTO convertToDto(Vehiculo vehiculo) {
        return modelMapper.map(vehiculo, VehiculoDTO.class);
    }
    private VehiculoSiniestroDTO convertToDTOVehiculoSiniestro(VehiculoSiniestro vehiculoSiniestro) {
        return modelMapper.map(vehiculoSiniestro, VehiculoSiniestroDTO.class);
    }



}
