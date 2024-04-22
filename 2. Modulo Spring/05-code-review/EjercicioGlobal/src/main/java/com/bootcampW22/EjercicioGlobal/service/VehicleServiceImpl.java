package com.bootcampW22.EjercicioGlobal.service;

import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import com.bootcampW22.EjercicioGlobal.entity.Vehicle;
import com.bootcampW22.EjercicioGlobal.exception.NotFoundException;
import com.bootcampW22.EjercicioGlobal.repository.IVehicleRepository;
import com.bootcampW22.EjercicioGlobal.repository.VehicleRepositoryImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class VehicleServiceImpl implements IVehicleService{

    IVehicleRepository vehicleRepository;

    ObjectMapper mapper = new ObjectMapper();


    public VehicleServiceImpl(VehicleRepositoryImpl vehicleRepository){
        this.vehicleRepository = vehicleRepository;
    }
    @Override
    public List<VehicleDto> searchAllVehicles() {
        List<Vehicle> vehicleList = vehicleRepository.findAll();
        if(vehicleList.isEmpty()){
            throw new NotFoundException("No se encontró ningun auto en el sistema.");
        }
        return vehicleList.stream()
                .map(v -> mapper.convertValue(v,VehicleDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public String createVehicle(VehicleDto vehicleDto) {
        Long lastId = vehicleRepository.getLastVehicleId() + 1;
        Vehicle vehicle = convertVehicleDtoToVehicle(vehicleDto);
        vehicle.setId(lastId);

        vehicleRepository.saveVehicle(vehicle);
        return "Vehiculo creado con ID: " + lastId;
    }

    @Override
    public List<VehicleDto> getVehiclesByColorAndYear(String color, int year) {
        List<VehicleDto> vehicles = vehicleRepository.findAll().stream()
                .filter(vehicle -> vehicle.getColor().equalsIgnoreCase(color) && vehicle.getYear() == year)
                .map(this::convertVehicleToVehicleDto).toList();

        if(vehicles.isEmpty()){
            throw new NotFoundException("No se encuentran vehiculos con las caracteristicas proporcionadas");
        }else{
            return vehicles;
        }
    }

    @Override
    public List<VehicleDto> getVehiclesByBrandAndYearRange(String brand, int startYear, int endYear) {
        List<VehicleDto> vehicles = vehicleRepository.findAll().stream()
                .filter(vehicle -> vehicle.getBrand().equalsIgnoreCase(brand)
                && (vehicle.getYear() >= startYear && vehicle.getYear() <= endYear))
                .map(this::convertVehicleToVehicleDto).toList();

        if(vehicles.isEmpty()){
            throw new NotFoundException("No se encuentran vehiculos con las caracteristicas proporcionadas");
        }else{
            return vehicles;
        }
    }

    @Override
    public String getAverageSpeedByBrand(String brand) {
        List<VehicleDto> vehicles = vehicleRepository.findAll().stream()
                .filter(vehicle -> vehicle.getBrand().equalsIgnoreCase(brand))
                .map(this::convertVehicleToVehicleDto).toList();

        if(vehicles.isEmpty()){
            throw new NotFoundException("No se encuentran vehiculos con las caracteristicas proporcionadas");
        }else{
            Double averageSpeed = vehicles.stream().mapToDouble(vehicle -> Double.parseDouble(vehicle.getMax_speed()))
                    .average().orElse(0);
            return "La velocidad promedio de la marca " + brand + " es " + averageSpeed;
        }
    }

    @Override
    public String createMultipleVehicles(List<VehicleDto> vehicles) {
        vehicles.forEach(this::createVehicle);
        return "Multiples vehiculos creados";
    }

    @Override
    public String updateVehicleMaxSpeed(int id, VehicleDto vehicleDto) {
        Optional<Vehicle> vehicleToUpdate = vehicleRepository.findAll().stream()
                .filter(vehicle -> vehicle.getId() == id).findFirst();

        if(vehicleToUpdate.isPresent()){
            Vehicle vehicle = vehicleToUpdate.get();

            if(Integer.parseInt(vehicleDto.getMax_speed()) < 0){
                throw new IllegalArgumentException("La velocidad maxima no puede ser menor a 0");
            }

            vehicle.setMax_speed(vehicleDto.getMax_speed());
            vehicleRepository.saveVehicle(vehicle);
            return "El vehiculo con la ID " + id + " ha sido actualizado";
        }else{
            throw new NotFoundException("No se encuentran vehiculos con las caracteristicas proporcionadas");
        }
    }

    @Override
    public List<VehicleDto> getVehiclesByFuelType(String fuelType) {
        return vehicleRepository.findAll().stream()
                .filter(vehicle -> vehicle.getFuel_type().equalsIgnoreCase(fuelType))
                .map(this::convertVehicleToVehicleDto).toList();
    }

    @Override
    public String deleteVehicle(int id) {
        Optional<Vehicle> vehicleToDelete = vehicleRepository.findAll().stream()
                .filter(vehicle -> vehicle.getId() == id).findFirst();

        if(vehicleToDelete.isPresent()){
            vehicleRepository.deleteVehicle(vehicleToDelete.get());
            return "El vehiculo con la ID: " + id + " ha sido eliminado";
        }else{
            throw new NotFoundException("No se encontro el vehiculo con la ID proporcionada");
        }
    }

    @Override
    public List<VehicleDto> getVehiclesByTransmissionType(String type) {
        List<VehicleDto> vehicles = vehicleRepository.findAll().stream()
                .filter(vehicle -> vehicle.getTransmission().equalsIgnoreCase(type))
                .map(this::convertVehicleToVehicleDto).toList();

        if(vehicles.isEmpty()){
            throw new NotFoundException("No se encuentran vehiculos con las caracteristicas proporcionadas");
        }else{
            return vehicles;
        }
    }

    @Override
    public String updatedVehicleFuelType(int id, VehicleDto vehicleDto) {
        Optional<Vehicle> vehicleToDelete = vehicleRepository.findAll().stream()
                .filter(vehicle -> vehicle.getId() == id).findFirst();

        if(vehicleToDelete.isPresent()){
            Vehicle vehicle = vehicleToDelete.get();
            vehicle.setFuel_type(vehicleDto.getFuel_type());

            vehicleRepository.saveVehicle(vehicle);

            return "El vehiculo con la ID " + vehicle.getId() + " ha sido actualizado";
        }else{
            throw new NotFoundException("El vehiculo con la ID proporcionada no fue encontrado");
        }
    }

    @Override
    public Double getVehicleAverageCapacityByBrand(String brand) {
        List<VehicleDto> vehicles = vehicleRepository.findAll().stream()
                .filter(vehicle -> vehicle.getBrand().equalsIgnoreCase(brand))
                .map(this::convertVehicleToVehicleDto).toList();

        if(vehicles.isEmpty()){
            throw  new NotFoundException("No se encuentran vehiculos con las caracteristicas proporcionadas");
        }else{
            return vehicles.stream().mapToDouble(VehicleDto::getPassengers)
                    .average().orElse(0);
        }
    }

    @Override
    public List<VehicleDto> getVehiclesByDimensions(double minLength, double maxLength, double minWidth, double maxWidth) {
        List<VehicleDto> vehicles = vehicleRepository.findAll().stream()
                .filter(vehicle -> (vehicle.getHeight() >= minLength && vehicle.getHeight() <= maxLength)
                && (vehicle.getWidth() >= minWidth && vehicle.getWidth() <= maxWidth))
                .map(this::convertVehicleToVehicleDto).toList();

        if(vehicles.isEmpty()){
            throw new NotFoundException("No se encuentran vehiculos con las caracteristicas proporcionadas");
        }else{
            return vehicles;
        }
    }

    @Override
    public List<VehicleDto> getVehiclesByWeightRange(double minWeight, double maxWeight) {
        List<VehicleDto> vehicles = vehicleRepository.findAll().stream()
                .filter(vehicle -> vehicle.getWeight() >= minWeight && vehicle.getWeight() <= maxWeight)
                .map(this::convertVehicleToVehicleDto).toList();

        if(vehicles.isEmpty()){
            throw new NotFoundException("No se encuentran vehiculos con las caracteristicas proporcionadas");
        }else{
            return vehicles;
        }
    }

    private Vehicle convertVehicleDtoToVehicle(VehicleDto vehicleDto){
        return mapper.convertValue(vehicleDto, Vehicle.class);
    }

    private VehicleDto convertVehicleToVehicleDto(Vehicle vehicle){
        return mapper.convertValue(vehicle, VehicleDto.class);
    }
}
