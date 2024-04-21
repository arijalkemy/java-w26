package org.example.ejercicio_concesionario.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.example.ejercicio_concesionario.dto.CarRequestDTO;
import org.example.ejercicio_concesionario.dto.CarResponseDTO;
import org.example.ejercicio_concesionario.models.Car;
import org.example.ejercicio_concesionario.repository.ICarDealershipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class CarDealershipServiceImpl implements ICarDealershipService{
    @Autowired
    ICarDealershipRepository carRepository;

    ObjectMapper mapper;

    public CarDealershipServiceImpl() {
        mapper=new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
    }

    @Override
    public CarResponseDTO addCar(CarRequestDTO carRequestDTO) {
        carRepository.save(mapper.convertValue(carRequestDTO, Car.class));
        return mapper.convertValue(carRequestDTO,CarResponseDTO.class);
    }

    @Override
    public List<CarResponseDTO> getAllCars() {
        return carRepository.findAll()
                .stream()
                .map(x->mapper.convertValue(x,CarResponseDTO.class))
                .toList();
    }

    @Override
    public List<CarResponseDTO> getCarsByDateRange(LocalDate since, LocalDate to) {
        return carRepository.findByDateRange(since, to)
                .stream()
                .map(x->mapper.convertValue(x, CarResponseDTO.class))
                .toList();
    }

    @Override
    public List<CarResponseDTO> getCarsByPriceRange(Double priceMin, Double priceMax) {
        return carRepository.findByPriceRange(priceMin, priceMax)
                .stream()
                .map(x->mapper.convertValue(x, CarResponseDTO.class))
                .toList();
    }

    @Override
    public CarResponseDTO getCarById(Long id) {
        return mapper.convertValue(carRepository.findById(id),CarResponseDTO.class);
    }
}
