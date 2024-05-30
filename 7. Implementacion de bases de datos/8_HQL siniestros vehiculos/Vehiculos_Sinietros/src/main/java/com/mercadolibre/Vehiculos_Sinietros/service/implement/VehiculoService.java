package com.mercadolibre.Vehiculos_Sinietros.service.implement;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercadolibre.Vehiculos_Sinietros.model.dto.VehiculoRequestDto;
import com.mercadolibre.Vehiculos_Sinietros.model.dto.VehiculoResponseDto;
import com.mercadolibre.Vehiculos_Sinietros.model.entity.Vehiculo;
import com.mercadolibre.Vehiculos_Sinietros.repository.IVehiculoRepository;
import com.mercadolibre.Vehiculos_Sinietros.service.IVehiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehiculoService implements IVehiculoService {
    ObjectMapper mapper = new ObjectMapper();

    @Autowired
    IVehiculoRepository vehiculoRepository;

    @Override
    public VehiculoResponseDto saveVehiculo(VehiculoRequestDto siniestro) {
        return convertToVehiculoResponseDto(vehiculoRepository.save(convertToVehiculo(siniestro)));
    }

    @Override
    public List<VehiculoResponseDto> getAllVehiculo() {
        return vehiculoRepository.findAll()
                .stream().map(this::convertToVehiculoResponseDto).toList();
    }

    @Override
    public VehiculoResponseDto getVehiculoById(Long id) {
        return convertToVehiculoResponseDto(vehiculoRepository.findById(id).orElse(null));
    }

    @Override
    public List<VehiculoResponseDto> findPatentAllVehicle() {
        return vehiculoRepository.findPatentAllVehicle().stream()
                .map(this::convertToVehiculoResponseDto).toList();
    }

    @Override
    public List<VehiculoResponseDto> findPatentAndBrandAllVehicleOrderByYearManufacture() {
        return vehiculoRepository.findPatentAndBrandAllVehicleOrderByYearManufacture()
                .stream().map(this::convertToVehiculoResponseDto).toList();
    }

    @Override
    public List<VehiculoResponseDto> findPatentAllVehicleWithFourWheelsAndManufactureCurrentYear() {
        return vehiculoRepository.findPatentAllVehicleWithFourWheelsAndManufactureCurrentYear()
                .stream().map(this::convertToVehiculoResponseDto).toList();
    }

    @Override
    public List<VehiculoResponseDto> findAllVehicleWithCrashOver10000() {
        return vehiculoRepository.findAllVehicleWithCrashOver10000().stream()
                .map(this::convertToVehiculoResponseDto).toList();
    }

    @Override
    public List<VehiculoResponseDto> findAllVehicleWithCrashOver10000AndTotalLoss() {
        return vehiculoRepository.findAllVehicleWithCrashOver10000AndTotalLoss()
                .stream().map(this::convertToVehiculoResponseDto).toList();
    }

    private Vehiculo convertToVehiculo(VehiculoRequestDto vehiculoRequest){
        return mapper.convertValue(vehiculoRequest, Vehiculo.class);
    }

    private VehiculoResponseDto convertToVehiculoResponseDto(Vehiculo vehiculo){
        return mapper.convertValue(vehiculo,VehiculoResponseDto.class);
    }
}
