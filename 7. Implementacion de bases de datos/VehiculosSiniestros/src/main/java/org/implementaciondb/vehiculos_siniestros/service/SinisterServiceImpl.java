package org.implementaciondb.vehiculos_siniestros.service;

import org.implementaciondb.vehiculos_siniestros.exception.NotFoundException;
import org.implementaciondb.vehiculos_siniestros.mapper.SinisterMapper;
import org.implementaciondb.vehiculos_siniestros.model.dto.sinister.SinisterRequestDto;
import org.implementaciondb.vehiculos_siniestros.model.dto.sinister.SinisterResponseDto;
import org.implementaciondb.vehiculos_siniestros.model.dto.sinister.SinisterWithoutVehicleDto;
import org.implementaciondb.vehiculos_siniestros.model.entity.Sinister;
import org.implementaciondb.vehiculos_siniestros.model.entity.Vehicle;
import org.implementaciondb.vehiculos_siniestros.repository.ISinisterRepository;
import org.implementaciondb.vehiculos_siniestros.repository.IVehicleRepository;
import org.implementaciondb.vehiculos_siniestros.service.interfaces.ISinisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SinisterServiceImpl implements ISinisterService {

    @Autowired
    private ISinisterRepository sinisterRepository;

    @Autowired
    private IVehicleRepository vehicleRepository;

    @Override
    public SinisterResponseDto saveSinister(SinisterRequestDto sinisterRequestDto) {
        Vehicle vehicle = vehicleRepository.getById(sinisterRequestDto.getVehicleId());
        if (vehicle == null) {
            throw new NotFoundException("No existe un vehiculo con dicho ID");
        }
        Sinister sinister = SinisterMapper.mapToSinister(sinisterRequestDto);
        sinister.setVehicle(vehicle);
        sinister = sinisterRepository.save(sinister);
        return SinisterMapper.mapToSinisterResponseDto(sinister);
    }

    @Override
    public SinisterResponseDto findSinisterById(Long id) {
        Optional<Sinister> sinisterOptional = sinisterRepository.findById(id);
        Sinister sinister = sinisterOptional.orElseThrow(
                () -> new NotFoundException("No se encontró un Siniestro con dicho ID: " + id)
        );
        sinister.setVehicle(getVehicleById(sinister.getId()));
        return SinisterMapper.mapToSinisterResponseDto(sinister);
    }

    @Override
    public List<SinisterWithoutVehicleDto> findSinistesrByVehicleId(Long vehicleId) {
        getVehicleById(vehicleId);
        List<Sinister> sinisters = sinisterRepository.findByVehicleId(vehicleId);
        if (sinisters.isEmpty()) {
            throw new NotFoundException("No se encocntró un Siniestros para ele vehículo dado");
        }
        return sinisters.stream().map(SinisterMapper::mapToSinisterWithoutVehicleDto).toList();
    }

    private Vehicle getVehicleById(Long id) {
        Optional<Vehicle> vehicleOptional = vehicleRepository.findById(id);
        return vehicleOptional.orElseThrow(
                () -> new NotFoundException("No existe un vehiculo con dicho id")
        );
    }

}
