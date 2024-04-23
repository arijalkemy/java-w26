package com.demospring.concesionariodeautos.service;

import com.demospring.concesionariodeautos.dto.CarDTO;
import com.demospring.concesionariodeautos.dto.CarResponseDTO;
import com.demospring.concesionariodeautos.repository.ICarRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ConsecionariaServicesImpl implements IConsecionariaServices{
    private final ICarRepository carRepository;

    public ConsecionariaServicesImpl(ICarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public void addCar(CarDTO carDTO) {
        this.carRepository.addCar(carDTO);
    }

    @Override
    public List<CarResponseDTO> getCars() {
        List<CarDTO> carsDtos = carRepository.getCars();
        List<CarResponseDTO> carResponseDTOs = new ArrayList<>();
        for (CarDTO carDto : carsDtos) {
            carResponseDTOs.add(new CarResponseDTO(carDto.getId(), carDto.getBrand(), carDto.getModel(), carDto.getManufacturingDate(), carDto.getNumberOfKilometres(), carDto.getDoors(), carDto.getPrice(), carDto.getCurrency(), carDto.getCountOfOwners()));
        }
        return carResponseDTOs;
    }

    @Override
    public List<CarResponseDTO> findCarsByManufacturingDate(String since, String to) {
        return List.of();
    }

    @Override
    public List<CarResponseDTO> findCarsByPrice(double since, double to) {
        return List.of();
    }

    @Override
    public CarDTO findCarById(int id) {
        return this.carRepository.findCarById(id);
    }
}
