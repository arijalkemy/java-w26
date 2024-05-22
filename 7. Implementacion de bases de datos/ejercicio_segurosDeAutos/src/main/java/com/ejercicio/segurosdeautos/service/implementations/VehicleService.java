package com.ejercicio.segurosdeautos.service.implementations;

import com.ejercicio.segurosdeautos.DTO.VehicleDTO;
import com.ejercicio.segurosdeautos.model.Sinister;
import com.ejercicio.segurosdeautos.model.Vehicle;
import com.ejercicio.segurosdeautos.proyections.VehicleProjections;
import com.ejercicio.segurosdeautos.repository.SinisterRepository;
import com.ejercicio.segurosdeautos.repository.VehicleRepository;
import com.ejercicio.segurosdeautos.service.interfaces.IVehicleService;
import jakarta.annotation.PostConstruct;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@Service
public class VehicleService implements IVehicleService {

    @Autowired
    private VehicleRepository vehicleRepository;
    @Autowired
    private SinisterRepository sinisterRepository;

    @Override
    public List<VehicleDTO> findVehiclesByEchonomicLostGreatherThan() {
        return vehicleRepository.findTotalEchonomicLostGreatherThan().stream().map(this::ProyectionToDto).toList();
    }

    @Override
    public List<VehicleDTO> findVehiclesByEchonomicLost() {
        return vehicleRepository.findVehiclesByEchonomicLost().stream().map(this::ProyectionToDto).toList();
    }

    @Override
    public List<VehicleDTO> findAllPatents() {
        return vehicleRepository.findAllPatents().stream().map(this::ProyectionToDto).toList();
    }

    @Override
    public List<VehicleDTO> findAllVehiclesOrderByFabricationYear() {
        return vehicleRepository.findAllVehiclesOrderByFabricationYear().stream().map(this::ProyectionToDto).toList();
    }

    @Override
    public List<VehicleDTO> findPatentsByWheelsAndYear() {
        return vehicleRepository.findPatentsByWheelsAndYear(LocalDate.now().getYear()).stream().map(this::ProyectionToDto).toList();
    }

    public VehicleDTO ProyectionToDto(VehicleProjections vehicleProjections)
    {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(vehicleProjections, VehicleDTO.class);
    }

   /* @PostConstruct
    public void initData() {
        Vehicle vehicle1 = new Vehicle();
        vehicle1.setPatent("ABC123");
        vehicle1.setBrand("Toyota");
        vehicle1.setModel("Corolla");
        vehicle1.setFebricationYear(LocalDate.of(2020, 1, 1));
        vehicle1.setWheels(20);

        Sinister sinister1 = new Sinister();
        sinister1.setDate(LocalDate.now());
        sinister1.setEconomicLost(5000);
        sinister1.setVehicle(vehicle1);

        Sinister sinister2 = new Sinister();
        sinister2.setDate(LocalDate.now());
        sinister2.setEconomicLost(7000);
        sinister2.setVehicle(vehicle1);

        vehicle1.setReported(Arrays.asList(sinister1, sinister2));

        vehicleRepository.save(vehicle1);
        sinisterRepository.saveAll(Arrays.asList(sinister1, sinister2));
    }*/
}
