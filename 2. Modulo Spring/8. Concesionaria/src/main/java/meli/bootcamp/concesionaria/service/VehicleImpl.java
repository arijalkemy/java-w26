package meli.bootcamp.concesionaria.service;

import lombok.RequiredArgsConstructor;
import meli.bootcamp.concesionaria.dto.VehicleDto;
import meli.bootcamp.concesionaria.dto.VehicleServiceDto;
import meli.bootcamp.concesionaria.dto.mapper.Mapper;
import meli.bootcamp.concesionaria.repository.VehicleRepository;
import meli.bootcamp.concesionaria.service.interfaces.IVehicle;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class VehicleImpl implements IVehicle {

    private final VehicleRepository vehicleRepository;

    @Override
    public List<VehicleServiceDto> addVehicle(List<VehicleServiceDto> vehicleServiceDto) {
        vehicleRepository.save(vehicleServiceDto.stream().map(Mapper::toVehicle).toList());
        return vehicleServiceDto;
    }

    @Override
    public List<VehicleDto> getVehicles() {
        return vehicleRepository.findAll()
                .stream()
                .map(Mapper::toVehicleDto)
                .toList();
    }

    @Override
    public VehicleServiceDto getVehicleById(Integer id) {
        return Mapper.toVehicleServiceDto(vehicleRepository.findById(id));
    }

    @Override
    public List<VehicleServiceDto> getVehiclesFilterDate(String dateSince, String dateUntil) {
        return vehicleRepository.findAll()
                .stream()
                .filter(v -> LocalDate.parse(v.getManufacturingDate()).isAfter(LocalDate.parse(dateSince)) &&
                        LocalDate.parse(v.getManufacturingDate()).isBefore(LocalDate.parse(dateUntil)))
                .map(Mapper::toVehicleServiceDto)
                .toList();
    }

    @Override
    public List<VehicleServiceDto> getVehiclesFilterPrice(Integer priceSince, Integer priceUntil) {
        return vehicleRepository.findAll()
                .stream()
                .filter(v -> Integer.parseInt(v.getPrice()) >= priceSince &&
                        Integer.parseInt(v.getPrice()) <= priceUntil)
                .map(Mapper::toVehicleServiceDto)
                .toList();
    }
}
