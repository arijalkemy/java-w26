package org.example.vehiculossiniestros.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.example.vehiculossiniestros.dto.PatenteMarcaDTO;
import org.example.vehiculossiniestros.dto.PatenteMarcaModeloDTO;
import org.example.vehiculossiniestros.dto.VehiculoSiniestroDTO;
import org.example.vehiculossiniestros.repository.IVehiculoRepository;
import org.example.vehiculossiniestros.service.IVehiculoService;
import org.springframework.stereotype.Service;

import java.time.Year;
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
    public List<PatenteMarcaDTO> getPatenteAndMarcaFromVehiculoOrderByAnio() {
        return vehiculoRepository.getPatenteAndMarcaFromVehiculoOrderByAnioDeFabricacion()
                .stream()
                .map(
                        x -> objectMapper.convertValue(x, PatenteMarcaDTO.class)
                ).toList();
    }

    @Override
    public List<String> getPatenteFromVehiculosWithMoreThan4WheelsAndManufacturedThisYear() {
        int currentYear = Year.now().getValue();
        return vehiculoRepository.getPatenteFromVehiculosWithMoreThan4WheelsAndManufacturedThisYear(currentYear);
    }

    @Override
    public List<PatenteMarcaModeloDTO> getPatenteMarcaModeloWhereSiniestroIsBig() {
        return vehiculoRepository.getPatenteMarcaModeloWhereSiniestroIsBig()
                .stream()
                .map(
                        x -> objectMapper.convertValue(x, PatenteMarcaModeloDTO.class)
                ).toList();
    }

    @Override
    public List<VehiculoSiniestroDTO> getPatenteMarcaModeloAndTotalLossWhereSiniestroIsBig() {
        return vehiculoRepository.getPatenteMarcaModeloAndTotalLossWhereSiniestroIsBig()
                .stream()
                .map(
                        x -> objectMapper.convertValue(x, VehiculoSiniestroDTO.class)
                ).toList();
    }
}
