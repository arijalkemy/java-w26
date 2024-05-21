package org.implementaciondb.vehiculos_siniestros.service.interfaces;

import org.implementaciondb.vehiculos_siniestros.model.dto.sinister.SinisterRequestDto;
import org.implementaciondb.vehiculos_siniestros.model.dto.sinister.SinisterResponseDto;
import org.implementaciondb.vehiculos_siniestros.model.dto.sinister.SinisterWithoutVehicleDto;

import java.util.List;

public interface ISinisterService {
    SinisterResponseDto saveSinister(SinisterRequestDto sinisterRequestDto);

    SinisterResponseDto findSinisterById(Long id);

    List<SinisterWithoutVehicleDto> findSinistesrByVehicleId(Long vehicleId);
}
