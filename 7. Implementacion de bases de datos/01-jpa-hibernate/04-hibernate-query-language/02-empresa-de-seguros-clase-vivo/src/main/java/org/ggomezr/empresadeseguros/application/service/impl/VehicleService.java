package org.ggomezr.empresadeseguros.application.service.impl;

import org.ggomezr.empresadeseguros.application.service.interfaces.IVehicleService;
import org.ggomezr.empresadeseguros.domain.dto.ResponseDTO;
import org.ggomezr.empresadeseguros.domain.dto.VehicleDTO;
import org.ggomezr.empresadeseguros.domain.exception.NotFoundException;
import org.ggomezr.empresadeseguros.domain.model.Vehicle;
import org.ggomezr.empresadeseguros.domain.repository.IVehicleRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleService implements IVehicleService {

    private final IVehicleRepository vehicleRepository;
    private final ModelMapper modelMapper;

    public VehicleService(IVehicleRepository vehicleRepository, ModelMapper modelMapper) {
        this.vehicleRepository = vehicleRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public VehicleDTO createVehicle(VehicleDTO vehicleDTO) {
        Vehicle vehicle = convertToEntity(vehicleDTO);
        Vehicle savedVehicle = vehicleRepository.save(vehicle);
        return convertToDTO(savedVehicle);
    }

    @Override
    public List<VehicleDTO> createVehicles(List<VehicleDTO> vehicleDTOList) {
        List<Vehicle> vehicles = vehicleDTOList.stream().map(this::convertToEntity).toList();
        List<Vehicle> savedVehicles = vehicleRepository.saveAll(vehicles);
        return savedVehicles.stream().map(this::convertToDTO).toList();
    }

    @Override
    public List<VehicleDTO> getAllVehicles() {
        return vehicleRepository.findAll().stream().map(this::convertToDTO).toList();
    }

    @Override
    public VehicleDTO getVehicleById(Long id) {
        Optional<Vehicle> vehicle = vehicleRepository.findById(id);

        if(vehicle.isEmpty()) throw new NotFoundException("Vehicle not found");

        return convertToDTO(vehicle.get());
    }

    @Override
    public VehicleDTO updateVehicle(Long id, VehicleDTO vehicleDTO) {
        Optional<Vehicle> vehicle = vehicleRepository.findById(id);

        if(vehicle.isEmpty()) throw new NotFoundException("Vehicle not found");

        Vehicle updatedVehicle = convertToEntity(vehicleDTO);
        updatedVehicle.setId(vehicle.get().getId());

        vehicleRepository.save(updatedVehicle);

        return convertToDTO(updatedVehicle);
    }

    @Override
    public ResponseDTO deleteVehicle(Long id) {
        Optional<Vehicle> vehicle = vehicleRepository.findById(id);

        if(vehicle.isEmpty()) throw new NotFoundException("Vehicle not found");

        vehicleRepository.deleteById(id);

        return new ResponseDTO("Vehicle deleted successfully");
    }

    @Override
    public List<String> getAllByPatents() {
        return vehicleRepository.findAllByPatents();
    }

    @Override
    public List<String> getAllByPatentAndBrandOrderByFabricationYear() {
        return vehicleRepository.findAllByPatentAndBrandOrderByFabricationYear();
    }

    @Override
    public List<String> getAllByPatentWithMoreThanFourWheelsAndFabricatedThisYear() {
        return vehicleRepository.findAllByPatentWithMoreThanFourWheelsAndFabricatedThisYear();
    }

    @Override
    public List<String> getAllBySinisterEconomicLossGreaterThan10000() {
        return vehicleRepository.findAllBySinisterEconomicLossGreaterThan10000();
    }

    @Override
    public List<String> getAllVehiclesWithMajorLosses() {
        return vehicleRepository.findAllVehiclesWithMajorLosses();
    }

    private VehicleDTO convertToDTO(Vehicle vehicle) {
        return modelMapper.map(vehicle, VehicleDTO.class);
    }

    private Vehicle convertToEntity(VehicleDTO vehicleDTO) {
        return modelMapper.map(vehicleDTO, Vehicle.class);
    }
}
