package org.example.concesionariaautos.service.imp;

import org.example.concesionariaautos.dto.CarWithoutServicesDTO;
import org.example.concesionariaautos.model.Car;
import org.example.concesionariaautos.repository.DealershipRepository;
import org.example.concesionariaautos.service.IDealershipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Service
public class DealershipServiceImp implements IDealershipService {
    @Autowired
    DealershipRepository dealershipRepository;

    @Override
    public void createVehicle() {

    }

    @Override
    public Car findById(Long id) {
        return null;
    }

    @Override
    public List<Car> findByDates(LocalDate since, LocalDate to) {
        return List.of();
    }

    @Override
    public List<Car> findByPrice(double since, double to) {
        return List.of();
    }

    @Override
    public List<CarWithoutServicesDTO> findAllCars() {
        List<Car> cars = dealershipRepository.getCars();
        return cars.stream().filter(Objects::nonNull)
                .map(c -> new CarWithoutServicesDTO(c))
                .toList();
    }
}
