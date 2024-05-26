package org.example.hqlvivo.Service.Impl;

import lombok.RequiredArgsConstructor;
import org.example.hqlvivo.DTOs.Request.CreateVehiculoRequestDto;
import org.example.hqlvivo.DTOs.Response.PatenteMarcaModeloResponseDto;
import org.example.hqlvivo.DTOs.Response.VehiculoResponseDto;
import org.example.hqlvivo.Repository.Entity.Vehiculo;
import org.example.hqlvivo.Repository.IVehiculoRepository;
import org.example.hqlvivo.Service.IVehiculoService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VehiculoServiceImpl implements IVehiculoService {
    private final IVehiculoRepository repository;

    @Override
    @Transactional
    public VehiculoResponseDto create(CreateVehiculoRequestDto vehiculoDto) {
        return new ModelMapper().map(
            repository.save(new ModelMapper().map(vehiculoDto, Vehiculo.class)),
            VehiculoResponseDto.class
        );
    }

    @Override
    @Transactional(readOnly = true)
    public List<VehiculoResponseDto> searchAll() {
        ModelMapper mapper = new ModelMapper();
        List<Vehiculo> vehiculos = repository.findAll();
        return vehiculos.stream().map(vehiculo -> mapper.map(vehiculo, VehiculoResponseDto.class)).toList();
    }

    @Override
    public List<String> searchAllPlates() {
        return repository.listAllPatentes();
    }

    @Override
    public List<PatenteMarcaModeloResponseDto> searchAllPatenteMarcaOrderAsc() {
        return repository.listAllPatenteMarcaOrderAsc();
    }

    @Override
    public List<String> searchAllPatentesByAnioAndMoreThanFourRuedas(Integer anio) {
        return repository.listAllPatentesByAnioAndMoreThanFourRuedas(anio);
    }
}
