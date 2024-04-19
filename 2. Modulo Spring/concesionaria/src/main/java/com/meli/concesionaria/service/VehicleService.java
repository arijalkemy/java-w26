package com.meli.concesionaria.service;

import com.meli.concesionaria.dto.RequestPostVehicleDto;
import com.meli.concesionaria.dto.ResponseVehicleDto;
import com.meli.concesionaria.entity.Vehicle;
import com.meli.concesionaria.repository.IRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class VehicleService {
    private IRepository<Vehicle> vehicleIRepository;

    @Autowired
    public VehicleService(IRepository<Vehicle> vehicleIRepository) {
        this.vehicleIRepository = vehicleIRepository;
    }

    public Vehicle addVehicle(RequestPostVehicleDto dto){
        Vehicle vehicle = parseDtoToVehicle(dto);
        return vehicleIRepository.add(vehicle);
    }

    public List<ResponseVehicleDto> getVehiclesByDate(String since, String to){
        List<ResponseVehicleDto> vehicles = parseToListDto(vehicleIRepository.getAll());
        return vehicles.stream()
                .filter(e->(validateDate(e.getManufacturingDate(),since,to)))
                .collect(Collectors.toList());
    }

    public List<ResponseVehicleDto> getVehiclesByPrice(Integer since, Integer to){
        List<ResponseVehicleDto> vehicles = parseToListDto(vehicleIRepository.getAll());
        return vehicles.stream()
                .filter(e-> validatePrice(e.getPrice(),since,to))
                .collect(Collectors.toList());
    }

    public Vehicle getVehicleById(Integer id){
        Optional<Vehicle> optionalVehicle = vehicleIRepository.getById(id);
        return optionalVehicle.orElseGet(Vehicle::new);
    }
    public List<ResponseVehicleDto> getAllVehicles(){
        List<Vehicle> vehicles = vehicleIRepository.getAll();
        return parseToListDto(vehicles);
    }

    /////////////METODOS PRIVADOS/////////////

    private List<ResponseVehicleDto> parseToListDto(List<Vehicle> vehicles){
        return vehicles.stream()
                .map(this::parseVehicleToDto)
                .collect(Collectors.toList());
    }

    private Vehicle parseDtoToVehicle(RequestPostVehicleDto dto){
        return new Vehicle(dto.getBrand(),dto.getModel(),dto.getManufacturingDate(),dto.getNumberOfKilometers(),dto.getDoors(),dto.getPrice(),dto.getCurrency(),dto.getServices());
    }

    private ResponseVehicleDto parseVehicleToDto(Vehicle v) {
        return new ResponseVehicleDto(v.getBrand(),v.getModel(),v.getManufacturingDate(),v.getNumberOfKilometers(),v.getDoors(),v.getPrice(),v.getCurrency());
    }

    private Boolean validateDate(String date, String since, String to){
        LocalDate carDate = LocalDate.parse(date);
        LocalDate madeAfter = LocalDate.parse(since);
        LocalDate madeBefore = LocalDate.parse(to);

        return carDate.isAfter(madeAfter) && carDate.isBefore(madeBefore);
    }

    private Boolean validatePrice(Integer price, Integer since, Integer to){
        return since <= price && price <= to;
    }
}
