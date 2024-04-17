package co.com.mercadolibre.autos.service;

import co.com.mercadolibre.autos.dto.VehicleDto;
import co.com.mercadolibre.autos.entity.Vehicle;

import java.util.List;

public interface IVehicleService {

    void save(Vehicle vehicle);
    VehicleDto findById(Integer id);
    List<VehicleDto> findAll();
    List<VehicleDto> findByManufacuringDate(String from, String to);
    List<VehicleDto> findByPrice(Integer minimumPrice, Integer maximumPrice);
}
