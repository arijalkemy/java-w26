package org.example.integradorcodereview.repository.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.integradorcodereview.entity.Vehicle;
import org.example.integradorcodereview.exception.ConflictException;
import org.example.integradorcodereview.exception.NotFoundException;
import org.example.integradorcodereview.repository.IVehicleRepository;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.Collector;

@Repository
public class VehicleRepositoryImpl implements IVehicleRepository{

        private List<Vehicle> vehicleList;
        ObjectMapper objectMapper;

    public VehicleRepositoryImpl() throws FileNotFoundException, IOException{
        vehicleList = new ArrayList<>();
        objectMapper = new ObjectMapper();
        loadDatabase();
    }

    private void loadDatabase() throws FileNotFoundException, IOException {
        File file;
        List<Vehicle> vehicles;
        file = ResourceUtils.getFile("classpath:vehicles.json");
        vehicles = objectMapper.readValue(file, new TypeReference<List<Vehicle>>(){});
        vehicleList = vehicles;
    }

    @Override
    public List<Vehicle> getAllVehicle() {
        return vehicleList;
    }

    @Override
    public Vehicle getVehicleById(Long vehicleId) {

        Optional<Vehicle> vehicle = getAllVehicle()
                .stream()
                .filter(v->v.getId().equals(vehicleId)).findFirst();
        if (vehicle.isPresent()){
            return vehicle.get();
        } else {
            throw new NotFoundException("Vehicle with id: "  + vehicleId + ", was not found");
        }
    }

    @Override
    public Vehicle addVehicle(Vehicle vehicle) {
        vehicleList.add(vehicle);
        return vehicle;
    }

    @Override
    public Boolean vehicleExists(Long id) {
        Optional<Vehicle> vehicle = getAllVehicle()
                .stream()
                .filter(v->v.getId().equals(id)).findFirst();

        return (vehicle.isPresent());
    }

    @Override
    public List<Vehicle> findVehiclesColorYear(String color, Integer year) {
        return getAllVehicle()
                .stream()
                .filter(v->v.getColor().equals(color)).filter(v->v.getYear().equals(year)).toList();
    }

    @Override
    public List<Vehicle> findVehiclesBrandYearRange(String brand, Integer startYear, Integer endYear) {
        return getAllVehicle()
                .stream()
                .filter(v->v.getBrand().equals(brand))
                .filter(v->v.getYear() >= startYear && v.getYear() <= endYear).toList();
    }

    @Override
    public Double getAverageSpeed(String brand) {
        OptionalDouble response = getAllVehicle().stream().filter(v->v.getBrand().equals(brand))
                .mapToDouble(Vehicle::getYear).average();
        if (response.isPresent()){
            return response.getAsDouble();
        } else {
            throw new NotFoundException("No vehicles found for operation");
        }
    }

    @Override
    public Vehicle updateVehicleSpeed(Long id, Vehicle vehicle) {
        if (vehicleExists(id)){
            int index = -1;
            for (int i = 0; i < vehicleList.size(); i++) {
                if (id.equals(vehicleList.get(i).getId())){
                    index = i;
                }
            }
            vehicleList.set(index, vehicle);
            return vehicleList.get(index);
        } else {
            throw new ConflictException("Error updating vehicle, vehicle do not exists");
        }
    }

    @Override
    public List<Vehicle> findVehiclesFuelType(String fuelType) {
        return vehicleList
                .stream()
                .filter(v->v.getFuel_type().equals(fuelType)).toList();
    }

    @Override
    public List<Vehicle> findVehiclesTransmissionType(String transmissionType) {
        return vehicleList
                .stream()
                .filter(v->v.getTransmission().equals(transmissionType)).toList();
    }

    @Override
    public void deleteVehicle(Long id) {
        Vehicle temp = new Vehicle();
        for(Vehicle v:vehicleList){
            if (v.getId().equals(id)) temp = v;
        }
        vehicleList.remove(temp);
    }

    @Override
    public Double getAveragePassengers(String brand){
        OptionalDouble response =  vehicleList
                .stream()
                .filter(vehicle -> vehicle.getBrand().equals(brand))
                .mapToDouble(Vehicle::getPassengers).average();
        if (response.isPresent()){
            return response.getAsDouble();
        } else {
            throw new NotFoundException("Brand was not found");
        }
    }

    @Override
    public List<Vehicle> findVehiclesMeasuresRange(Double minHeight, Double maxHeight, Double minWidth, Double maxWidth) {
        return vehicleList
                .stream()
                .filter(vehicle -> vehicle.getHeight() >= minHeight && vehicle.getHeight() <= maxHeight)
                .filter(vehicle -> vehicle.getWidth() >= minWidth && vehicle.getWidth() <= maxHeight)
                .toList();
    }

    @Override
    public List<Vehicle> findVehiclesWeightRange(Double minWeight, Double maxWeight) {
        return vehicleList
                .stream()
                .filter(vehicle -> vehicle.getWeight() >= minWeight && vehicle.getWeight() <= maxWeight)
                .toList();
    }
}
