package com.bootcamp.vehiculo.service.impl;

import com.bootcamp.vehiculo.dto.SiniestroDTO;
import com.bootcamp.vehiculo.mapper.SiniestroMapper;
import com.bootcamp.vehiculo.mapper.VehiculoMapper;
import com.bootcamp.vehiculo.model.Siniestro;
import com.bootcamp.vehiculo.model.Vehiculo;
import com.bootcamp.vehiculo.repository.ISiniestroRepository;
import com.bootcamp.vehiculo.service.ISiniestroService;
import com.bootcamp.vehiculo.service.IVehiculoService;
import org.springframework.stereotype.Service;

@Service
public class SiniestroServiceImpl implements ISiniestroService {

    private final ISiniestroRepository siniestroRepository;
    private final IVehiculoService vehiculoService;

    public SiniestroServiceImpl(ISiniestroRepository siniestroRepository, IVehiculoService vehiculoService){
        this.siniestroRepository = siniestroRepository;
        this.vehiculoService = vehiculoService;
    }

    @Override
    public SiniestroDTO save(Long vehiculoId, SiniestroDTO siniestroDTO) {
        Vehiculo vehiculo = VehiculoMapper.vehiculoDTOToVehiculo(
                vehiculoService.findById(vehiculoId));
        Siniestro siniestro = SiniestroMapper.siniestroDTOToSiniestro(siniestroDTO);
        siniestro.setVehiculo(vehiculo);
        return SiniestroMapper.siniestroToSiniestroDTO(siniestroRepository.save(siniestro));
    }
}
