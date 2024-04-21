package com.w26.concesionarioautos.controller;

import com.w26.concesionarioautos.dto.CarServices;
import com.w26.concesionarioautos.dto.CreationCarResult;
import com.w26.concesionarioautos.dto.GetCarFull;
import com.w26.concesionarioautos.dto.GetFilterCars;
import com.w26.concesionarioautos.services.ICreationCar;
import com.w26.concesionarioautos.services.IGetCarServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/v1/api")
public class CarController {

    final ICreationCar serviceCreation;
    final IGetCarServices getCarServices;

    public CarController(ICreationCar serviceCreation, IGetCarServices getCarServices) {
        this.serviceCreation = serviceCreation;
        this.getCarServices = getCarServices;
    }

    @PostMapping("/vehicles")
    public ResponseEntity<?> postCar(@RequestBody CarServices carServices)
    {
        CreationCarResult response = serviceCreation.createCar(carServices);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/vehicles")
    public ResponseEntity<?> getCarNotServices()
    {
        GetFilterCars getFilterCars = getCarServices.retriveCarNotServices();
        return ResponseEntity.status(HttpStatus.FOUND).body(getFilterCars);
    }

    @GetMapping("/vehicles/{id}")
    public ResponseEntity<?> getCar(@PathVariable Integer id)
    {
        GetCarFull getCarFull = getCarServices.retriveCarById(id);
        return ResponseEntity.status(HttpStatus.FOUND).body(getCarFull);
    }


    @GetMapping("/vehicles/prices")
    public ResponseEntity<?> getCarServicesFilterByPrices(@RequestParam Double since, @RequestParam Double to ) {
        GetFilterCars getFilterCars = getCarServices.retriveCarByRangePrice(since, to);

        return ResponseEntity.status(HttpStatus.FOUND).body(getFilterCars);
    }

    @GetMapping("/vehicles/dates")
    public ResponseEntity<?> getCarServicesFilterByDate(@RequestParam LocalDate since, @RequestParam LocalDate to ) {
        GetFilterCars getFilterCars = getCarServices.retriveCarByRangeDates(since, to);
        return ResponseEntity.status(HttpStatus.FOUND).body(getFilterCars);
    }

}
