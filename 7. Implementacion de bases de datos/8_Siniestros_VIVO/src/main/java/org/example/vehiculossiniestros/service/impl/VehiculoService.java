package org.example.vehiculossiniestros.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.example.vehiculossiniestros.dto.PatenteAndMarcaDTO;
import org.example.vehiculossiniestros.model.Vehiculo;
import org.example.vehiculossiniestros.repository.IVehiculoRepository;
import org.example.vehiculossiniestros.service.IVehiculoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VehiculoService implements IVehiculoService {

    private final IVehiculoRepository vehiculoRepository;

    private final ObjectMapper objectMapper;

    @Override
    public List<String> getPatentesFromAllVehiculos(){
        return vehiculoRepository.getPatenteFromAllVehiculo();
    }

    @Override
    public List<PatenteAndMarcaDTO> getPatenteAndMarcaFromVehiculoOrderByAnio() {
        return vehiculoRepository.getPatenteAndMarcaFromVehiculoOrderByAnioDeFabricacion()
                .stream()
                .map(
                        x -> objectMapper.convertValue(x, PatenteAndMarcaDTO.class)
                ).toList();
    }
}
