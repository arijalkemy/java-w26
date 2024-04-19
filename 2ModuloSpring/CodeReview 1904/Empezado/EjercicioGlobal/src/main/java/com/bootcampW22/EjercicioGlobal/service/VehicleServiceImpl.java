package com.bootcampW22.EjercicioGlobal.service;

import com.bootcampW22.EjercicioGlobal.dto.RequestVehicleDTO;
import com.bootcampW22.EjercicioGlobal.dto.ResponseDTO;
import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import com.bootcampW22.EjercicioGlobal.entity.Vehicle;
import com.bootcampW22.EjercicioGlobal.exception.NotFoundException;
import com.bootcampW22.EjercicioGlobal.repository.IVehicleRepository;
import com.bootcampW22.EjercicioGlobal.repository.VehicleRepositoryImpl;
import com.bootcampW22.EjercicioGlobal.utils.MapVehicle;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class VehicleServiceImpl implements IVehicleService{

    IVehicleRepository vehicleRepository;

    public VehicleServiceImpl(VehicleRepositoryImpl vehicleRepository){
        this.vehicleRepository = vehicleRepository;
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

    @Override
    public ResponseDTO addOneVehicle(RequestVehicleDTO dto) {
            Long id = vehicleRepository.getLast().getId()+1;
            Vehicle vehicleToAdd = MapVehicle.mapRequestDTOToVehicle(dto, id);
            vehicleRepository.addOne(vehicleToAdd);
            return new ResponseDTO("Vehiculo agregado correctamente con id " + id);
    }

    @Override
    public List<VehicleDto> SearchByFuelTyple(String fuelType) {
        List< VehicleDto> response = vehicleRepository.findByFuelType(fuelType).stream()
                .map(MapVehicle::mapDTOtoVehicle).toList();
        if(response.size()==0){
            throw new NotFoundException("no se encontraron vehiculos con ese tipo de combustible");
        }
        return response;
    }

    @Override
    public List<VehicleDto> SerachByDimension(double[] heigths, double[] widths) {
        List<VehicleDto> response = vehicleRepository.findByDimensions(
                heigths[0], heigths[1],
                widths[0], widths[1]).stream()
                .map(MapVehicle::mapDTOtoVehicle).toList();
        if(response.isEmpty()) throw  new NotFoundException("No se encontraron vehiculos con esas dimiensiones ");
        return response;
    }

}
