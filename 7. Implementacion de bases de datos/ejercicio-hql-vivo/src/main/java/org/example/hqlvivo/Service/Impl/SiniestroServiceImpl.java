package org.example.hqlvivo.Service.Impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.example.hqlvivo.Common.Errors.NotFoundException;
import org.example.hqlvivo.DTOs.Request.CreateSiniestroRequestDto;
import org.example.hqlvivo.DTOs.Response.PatenteMarcaModeloResponseDto;
import org.example.hqlvivo.DTOs.Response.PatenteMarcaModeloTotalPerdidaResponseDto;
import org.example.hqlvivo.DTOs.Response.SiniestroResponseDto;
import org.example.hqlvivo.Repository.Entity.Siniestro;
import org.example.hqlvivo.Repository.Entity.Vehiculo;
import org.example.hqlvivo.Repository.ISiniestroRepository;
import org.example.hqlvivo.Repository.IVehiculoRepository;
import org.example.hqlvivo.Service.ISiniestroService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SiniestroServiceImpl implements ISiniestroService {
    private final ISiniestroRepository siniestroRepository;
    private final IVehiculoRepository vehiculoRepository;
    private final ObjectMapper mapper;

    @Override
    @Transactional
    public SiniestroResponseDto create(CreateSiniestroRequestDto request) {
        Vehiculo vehiculo = vehiculoRepository.findById(request.getVehiculo_id())
            .orElseThrow(NotFoundException::new);

        Siniestro siniestro = Siniestro.builder()
            .fecha(request.getFecha())
            .perdida(request.getPerdida())
            .vehiculo(vehiculo)
            .build();

        siniestro = siniestroRepository.save(siniestro);

        return new ModelMapper().map(siniestro, SiniestroResponseDto.class);
    }

    @Override
    @Transactional(readOnly = true)
    public List<SiniestroResponseDto> searchAll() {
        ModelMapper mapper = new ModelMapper();
        return siniestroRepository.findAll()
            .stream().map(siniestro -> mapper.map(siniestro, SiniestroResponseDto.class))
            .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public List<PatenteMarcaModeloResponseDto> searchAllDatosSiniestroWithPerdidaMayorDiezMil() {
        return siniestroRepository.findAllDatosSiniestroWithPerdidaMayorDiezMil();
    }

    @Override
    @Transactional(readOnly = true)
    public List<PatenteMarcaModeloTotalPerdidaResponseDto> searchAllDatosSiniestroWithPerdidaMayorDiezMilAndTotalPerdida() {
        return siniestroRepository.findAllDatosSiniestroWithPerdidaMayorDiezMilAndTotalPerdida();
    }
}
