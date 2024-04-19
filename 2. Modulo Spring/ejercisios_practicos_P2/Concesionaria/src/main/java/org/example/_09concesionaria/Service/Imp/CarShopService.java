package org.example._09concesionaria.Service.Imp;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example._09concesionaria.DTO.AddVehicleRequestDTO;
import org.example._09concesionaria.DTO.GetCompleteVehicleResponseDTO;
import org.example._09concesionaria.DTO.GetVehicleWithoutServicesDTO;
import org.example._09concesionaria.Model.Vehicle;
import org.example._09concesionaria.Repository.IRepository;
import org.example._09concesionaria.Service.ICarShopService;
import org.example._09concesionaria.util.findinobject.FindByRangeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static java.util.Arrays.stream;

@Service
public class CarShopService implements ICarShopService {

    @Autowired
    IRepository vehicleRepository;

    @Autowired
    ObjectMapper objectMapper;

    @Override
    public Integer createVehicle(AddVehicleRequestDTO addVehicleRequestDTO) {
        Vehicle vehicle = new Vehicle(addVehicleRequestDTO);
        vehicleRepository.save(vehicle);
        return vehicle.getId();
    }

    @Override
    public List<GetVehicleWithoutServicesDTO> retrieveAllUsedVehicles() {
        return vehicleRepository.findAll().stream().filter(v -> v.getNumberOfKilometers() > 0)
                .map(v -> objectMapper.convertValue(v, GetVehicleWithoutServicesDTO.class))
                .toList();
    }

    @Override
    public GetCompleteVehicleResponseDTO retrieveVehicleById(Integer id) {
        Optional<Vehicle> vehicle = vehicleRepository.findById(id);
        if (vehicle.isPresent()) {
            return objectMapper.convertValue(vehicle.get(), GetCompleteVehicleResponseDTO.class);
        }
        return null;
    }


    public List<GetCompleteVehicleResponseDTO> retrieveByPrices(Integer minPrice, Integer maxPrice) {
        List<Vehicle> vehicles = vehicleRepository.findAll();
        return FindByRangeUtil.filterByRange(vehicles, minPrice, maxPrice, Vehicle::getPrice)
                .stream().map(o -> objectMapper.convertValue(
                                o, GetCompleteVehicleResponseDTO.class
                        )
                ).toList();
    }

    public List<GetCompleteVehicleResponseDTO> retrieveCarsByDatesRange(String minDate, String maxDate) {
        List<Vehicle> vehicles = vehicleRepository.findAll();
        LocalDate minLocalDate = LocalDate.parse(minDate);
        LocalDate maxLocalDate = LocalDate.parse(maxDate);

        Predicate<Vehicle> dateInRange = vehicle ->
                LocalDate.parse(vehicle.getManufacturingDate()).compareTo(minLocalDate) >= 0 &&
                        LocalDate.parse(vehicle.getManufacturingDate()).compareTo(maxLocalDate) <= 0;

        return vehicles.stream()
                .filter(dateInRange)
                .map(o -> objectMapper.convertValue(
                        o, GetCompleteVehicleResponseDTO.class
                ))
                .collect(Collectors.toList());
    }
}
