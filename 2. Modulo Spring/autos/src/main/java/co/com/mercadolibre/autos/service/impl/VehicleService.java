package co.com.mercadolibre.autos.service.impl;

import co.com.mercadolibre.autos.dto.VehicleDto;
import co.com.mercadolibre.autos.entity.Vehicle;
import co.com.mercadolibre.autos.repository.IVehicleRepository;
import co.com.mercadolibre.autos.service.IVehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class VehicleService implements IVehicleService {

    @Autowired
    private IVehicleRepository vehicleRepository;

    @Override
    public void save(Vehicle vehicle) {
        this.vehicleRepository.save(vehicle);
    }

    @Override
    public VehicleDto findById(Integer id) {
        VehicleDto vehicleDto = this.mapToDto(this.vehicleRepository.findById(id));
        return vehicleDto;
    }

    @Override
    public List<VehicleDto> findAll() {
        return this.vehicleRepository.findAll().stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<VehicleDto> findByManufacuringDate(String from, String to) {
        LocalDate fromLocalDate = convertStringToLocalDate(from);
        LocalDate toLocalDate = convertStringToLocalDate(to);

        List<Vehicle> consultList = vehicleRepository.findAll();
        return consultList.stream()
                .filter(vehicle -> isBetweenManufacturingDates(vehicle, fromLocalDate, toLocalDate))
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<VehicleDto> findByPrice(Integer minimumPrice, Integer maximumPrice) {
        List<Vehicle> consultList = vehicleRepository.findAll();
        return consultList.stream()
                .filter(vehicle -> vehicle.getPrice() >= minimumPrice && vehicle.getPrice() <= maximumPrice)
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    private VehicleDto mapToDto(Vehicle vehicle) {
        VehicleDto vehicleDto = new VehicleDto();
        vehicleDto.setBrand(vehicle.getBrand());
        vehicleDto.setModel(vehicle.getModel());
        vehicleDto.setManufacturingDate(vehicle.getManufacturingDate());
        vehicleDto.setNumberOfKilometers(vehicle.getNumberOfKilometers());
        vehicleDto.setDoors(vehicle.getDoors());
        vehicleDto.setPrice(vehicle.getPrice());
        vehicleDto.setCurrency(vehicle.getCurrency());
        vehicleDto.setCountOfOwners(vehicle.getCountOfOwners());
        return vehicleDto;
    }

    private LocalDate convertStringToLocalDate(String date) {
        try {
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            return LocalDate.parse(date, dateTimeFormatter);
        } catch (DateTimeParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    private boolean isBetweenManufacturingDates(Vehicle vehicle, LocalDate fromDate, LocalDate toDate) {
        LocalDate manufacturingDate = this.convertStringToLocalDate(vehicle.getManufacturingDate());
        return !manufacturingDate.isBefore(fromDate) && !manufacturingDate.isAfter(toDate);
    }
}
