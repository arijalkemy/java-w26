package com.bootcampW22.EjercicioGlobal.service;

import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import com.bootcampW22.EjercicioGlobal.entity.Vehicle;
import com.bootcampW22.EjercicioGlobal.exception.AlreadyExistException;
import com.bootcampW22.EjercicioGlobal.exception.BadFormatException;
import com.bootcampW22.EjercicioGlobal.exception.NotFoundException;
import com.bootcampW22.EjercicioGlobal.repository.IVehicleRepository;
import com.bootcampW22.EjercicioGlobal.repository.VehicleRepositoryImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class  VehicleServiceImpl implements IVehicleService{

    IVehicleRepository vehicleRepository;

    public VehicleServiceImpl(VehicleRepositoryImpl vehicleRepository){
        this.vehicleRepository = vehicleRepository;
    }

    @Override
    public void updateVehicleSpeed(Long id, String speed) {
        Optional<Vehicle> vehicle = vehicleRepository.findById(id);
        if(vehicle.isEmpty()){
            throw new NotFoundException("No se encontró el vehiculo con ID: " + id);
        }

        double speedValue = Double.parseDouble(speed);
        if(speed.isEmpty() || speed == null || speedValue < 0 || speedValue > 400){
            throw new BadFormatException("Error en el formato de la velocidad");
        }

        Vehicle foundVehicle = vehicle.get();

        foundVehicle.setMax_speed(speed);

        vehicleRepository.update(id, foundVehicle);
    }

    @Override
    public void updateVehicleFuel(Long id, String fuelType) {
        Optional<Vehicle> vehicle = vehicleRepository.findById(id);
        if(vehicle.isEmpty()){
            throw new NotFoundException("No se encontró el vehiculo con ID: " + id);
        }

        if(fuelType.isEmpty() ||  fuelType == null){
            throw new BadFormatException("Error en el formato de la velocidad");
        }

        Vehicle foundVehicle = vehicle.get();

        foundVehicle.setFuel_type(fuelType);

        vehicleRepository.update(id, foundVehicle);
    }

    @Override
    public List<VehicleDto> searchAllVehicles() {
        List<Vehicle> vehicleList = vehicleRepository.findAll();
        if(vehicleList.isEmpty()){
            throw new NotFoundException("No se encontró ningun auto en el sistema.");
        }
        return vehicleList.stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<VehicleDto> searchAllVehiclesByColorAndYear(String color, int year) {
        List<Vehicle> vehicleList = vehicleRepository.findAll();
        if(vehicleList.isEmpty()){
            throw new NotFoundException("No se encontró ningun auto en el sistema.");
        }

        List<VehicleDto> vehicleDtos = vehicleList.stream().filter(vehicle ->
                vehicle.getColor().equalsIgnoreCase(color) && vehicle.getYear() == year)
                .map(this::mapToDto)
                .toList();

        if(vehicleDtos.isEmpty()){
            throw new NotFoundException("No se encontró ningun auto en el sistema.");
        }

        return vehicleDtos;
    }

    @Override
    public List<VehicleDto> searchAllVehiclesByBrandAndRangeOfYears(String brand, int start_year, int end_year) {
        List<Vehicle> vehicleList = vehicleRepository.findAll();
        if(vehicleList.isEmpty()){
            throw new NotFoundException("No se encontró ningun auto en el sistema.");
        }

        List<VehicleDto> vehicleDtos = vehicleList.stream().filter(vehicle ->
                        vehicle.getBrand().equalsIgnoreCase(brand)
                        && vehicle.getYear() >= start_year
                        && vehicle.getYear() <= end_year)
                .map(this::mapToDto)
                .toList();

        if(vehicleDtos.isEmpty()){
            throw new NotFoundException("No se encontró ningun auto en el sistema.");
        }

        return vehicleDtos;
    }

    @Override
    public List<VehicleDto> searchAllVehiclesByFuelType(String type) {
        List<Vehicle> vehicleList = vehicleRepository.findAll().stream()
                .filter(vehicle -> vehicle.getFuel_type().equalsIgnoreCase(type)).toList();

        if (vehicleList.isEmpty()){
            throw new NotFoundException("No se encontraron vehículos con ese tipo de combustible.");
        }

        return vehicleList.stream().map(this::mapToDto).toList();
    }

    @Override
    public List<VehicleDto> searchAllVehiclesByTransmissionType(String type) {
        List<Vehicle> vehicleList = vehicleRepository.findAll().stream()
                .filter(vehicle -> vehicle.getTransmission().equalsIgnoreCase(type)).toList();

        if (vehicleList.isEmpty()){
            throw new NotFoundException("No se encontraron vehículos con ese tipo de combustible.");
        }

        return vehicleList.stream().map(this::mapToDto).toList();
    }

    @Override
    public Double getMeanSpeedByBrand(String brand) {
        List<Vehicle> vehicleList = vehicleRepository.findAll().stream()
                .filter(vehicle -> vehicle.getBrand().equalsIgnoreCase(brand)).toList();

        if(vehicleList.isEmpty()){
            throw new NotFoundException("No se encontró ningun auto en el sistema.");
        }

        Double meanSpeed = vehicleList
                .stream()
                .mapToDouble(v -> Double.parseDouble(v.getMax_speed()))
                .average()
                .orElse(0);

        return meanSpeed;
    }

    @Override
    public Double getMeanCapacityByBrand(String brand) {
        List<Vehicle> vehicleList = vehicleRepository.findAll().stream()
                .filter(vehicle -> vehicle.getBrand().equalsIgnoreCase(brand)).toList();

        if(vehicleList.isEmpty()){
            throw new NotFoundException("No se encontró ningun auto en el sistema.");
        }

        Double meanCapacity = vehicleList
                .stream()
                .mapToInt(v -> v.getPassengers())
                .average()
                .orElse(0);

        return meanCapacity;
    }

    @Override
    public List<VehicleDto> searchAllVehiclesByDimensions(String length, String width) {
        String[] lengthSplit = length.split("-");
        String[] widthSplit = width.split("-");

        Double min_length = Double.parseDouble(lengthSplit[0]);
        Double max_length = Double.parseDouble(lengthSplit[1]);
        Double min_width = Double.parseDouble(widthSplit[0]);
        Double max_width = Double.parseDouble(widthSplit[1]);

        List<Vehicle> vehicles = vehicleRepository.findAll().stream().filter(vehicle ->
                vehicle.getWidth() >= min_width
                && vehicle.getWidth() <= max_width
                && vehicle.getHeight() >= min_length
                && vehicle.getHeight() <= max_length
        ).toList();

        if(vehicles.isEmpty()){
            throw new NotFoundException("No se encontraron vehículos con esas dimensiones.");
        }

        return vehicles.stream().map(this::mapToDto).toList();
     }

    @Override
    public void createVehicle(VehicleDto vehicleDto) {
        if (checkFormat(vehicleDto)){
            throw new BadFormatException("El formato es incorrecto");
        }

        Optional<Vehicle> vehicleAlreadyExist = vehicleRepository.findById(vehicleDto.getId());
        if (vehicleAlreadyExist.isPresent()){
            throw new AlreadyExistException("El vehiculo con id: " + vehicleDto.getId() + " ya existe" );
        }


        Vehicle vehicle = mapToEntity(vehicleDto);
        vehicleRepository.save(vehicle);
    }

    @Override
    public void deleteVehicle(Long id) {
        Optional<Vehicle> vehicle = vehicleRepository.findById(id);
        if (vehicle.isEmpty()){
            throw new NotFoundException("No se encontró el vehículo.");
        }

        vehicleRepository.delete(id);
    }

    @Override
    public void createVehiclesBatch(List<VehicleDto> vehicleDtos) {
        vehicleDtos
                .stream()
                .forEach(vehicleDto -> {
                    if (checkFormat(vehicleDto)){
                        throw new BadFormatException("El formato es incorrecto");
                    }
                    Optional<Vehicle> vehicleAlreadyExist = vehicleRepository.findById(vehicleDto.getId());
                    if (vehicleAlreadyExist.isPresent()){
                        throw new AlreadyExistException("El vehiculo con id: " + vehicleDto.getId() + " ya existe" );
                    }
                   vehicleRepository.save(mapToEntity(vehicleDto));
                });
    }

    private Vehicle mapToEntity (VehicleDto vehicleDto){
        ObjectMapper mapper = new ObjectMapper();
        return mapper.convertValue(vehicleDto, Vehicle.class);
    }

    private VehicleDto mapToDto (Vehicle vehicle){
        ObjectMapper mapper = new ObjectMapper();
        return mapper.convertValue(vehicle, VehicleDto.class);
    }

    private Boolean checkFormat(VehicleDto vehicleDto){
        return vehicleDto.getBrand() == null
                        || vehicleDto.getColor().isEmpty() || vehicleDto.getColor() == null
                        || vehicleDto.getBrand().isEmpty() || vehicleDto.getBrand() == null
                        || vehicleDto.getRegistration().isEmpty() || vehicleDto.getRegistration() == null
                        || vehicleDto.getMax_speed().isEmpty() || vehicleDto.getMax_speed() == null
                        || vehicleDto.getFuel_type().isEmpty() || vehicleDto.getFuel_type() == null
                        || vehicleDto.getTransmission().isEmpty() || vehicleDto.getTransmission() == null
                        || vehicleDto.getYear() == 0
                        || vehicleDto.getHeight() == 0
                        || vehicleDto.getModel().isEmpty() || vehicleDto.getModel() == null
                        || vehicleDto.getPassengers() == 0
                        || vehicleDto.getWeight() == 0
                        || vehicleDto.getWidth() == 0;
    }

}
