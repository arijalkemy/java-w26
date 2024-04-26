package com.bootcampW22.EjercicioGlobal.service;

import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import com.bootcampW22.EjercicioGlobal.entity.Vehicle;
import com.bootcampW22.EjercicioGlobal.exception.NotFoundException;
import com.bootcampW22.EjercicioGlobal.repository.IVehicleRepository;
import com.bootcampW22.EjercicioGlobal.repository.VehicleRepositoryImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Vector;
import java.util.stream.Collectors;

@Service
public class VehicleServiceImpl implements IVehicleService{

    private final ObjectMapper objectMapper;

    IVehicleRepository vehicleRepository;

    public VehicleServiceImpl(VehicleRepositoryImpl vehicleRepository){

        this.vehicleRepository = vehicleRepository;
        this.objectMapper = new ObjectMapper().registerModule(new JavaTimeModule());
    }
    @Override
    public List<VehicleDto> searchAllVehicles() {
        ObjectMapper mapper = new ObjectMapper();
        List<Vehicle> vehicleList = vehicleRepository.findAll();
        if(vehicleList.isEmpty()){
            throw new NotFoundException("No se encontró ningun auto en el sistema.");
        }
        return vehicleList.stream()
                .map(v -> mapper.convertValue(v,VehicleDto.class))
                .collect(Collectors.toList());
    }

    public String saveData(VehicleDto vehicleDto ){
        Vehicle saveVehicle= this.objectMapper.convertValue(vehicleDto, Vehicle.class);

            return "Se ha guardado con el id: " + saveVehicle.getId();

    }

    @Override
    public VehicleDto searchById(Long id){
        Vehicle vehicle = (Vehicle) this.vehicleRepository.searchById(id);
        return this.objectMapper.convertValue(id, VehicleDto.class);
    }

    @Override
    public List<VehicleDto> searchByRange(double min, double max){
        ObjectMapper mapper = new ObjectMapper();
        List<Vehicle> vehicles = this.vehicleRepository.searchByRange(min, max);

        return  vehicles.stream()
                .map(v -> mapper.convertValue(v,VehicleDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public VehicleDto changeData(Long id, String fuel_type) {
        Optional<Vehicle> vehicle = this.vehicleRepository.changeData(id,fuel_type);
        if(vehicle.isEmpty()){
            throw new NotFoundException("no existe el vehiculo");
        }

        vehicle.get().setFuel_type(fuel_type);

        VehicleDto vehicleDto = new VehicleDto(vehicle.get().getId(), vehicle.get().getBrand(),
                vehicle.get().getModel(), vehicle.get().getRegistration(),
                vehicle.get().getColor(), vehicle.get().getYear(), vehicle.get().getMax_speed(),
                vehicle.get().getPassengers(),vehicle.get().getFuel_type(),
                vehicle.get().getTransmission(),vehicle.get().getHeight(),
                vehicle.get().getWidth(),vehicle.get().getWeight());

        return vehicleDto;
    }

    @Override
    public List<VehicleDto> searchByFuel(String fuel_type) {

        ObjectMapper mapper = new ObjectMapper();
        List<Vehicle> vehicles = this.vehicleRepository.searchByFuel(fuel_type);

        return  vehicles.stream()
                .map(v -> mapper.convertValue(v,VehicleDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public double searchBrandAvg(String brand) {

        return this.vehicleRepository.searchBrandAvg(brand);
    }


}
