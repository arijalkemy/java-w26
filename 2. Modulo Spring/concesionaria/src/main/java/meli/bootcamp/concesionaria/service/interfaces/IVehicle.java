package meli.bootcamp.concesionaria.service.interfaces;

import meli.bootcamp.concesionaria.dto.VehicleDto;
import meli.bootcamp.concesionaria.dto.VehicleServiceDto;

import java.util.List;

public interface IVehicle {
    List<VehicleServiceDto> addVehicle(List<VehicleServiceDto> vehicleServiceDtoDto);
    List<VehicleDto> getVehicles();
    VehicleServiceDto getVehicleById(Integer id);
    List<VehicleServiceDto> getVehiclesFilterDate(String dateSince, String dateUntil);
    List<VehicleServiceDto> getVehiclesFilterPrice(Integer priceSince, Integer priceUntil);
}
