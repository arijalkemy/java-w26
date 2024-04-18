package org.example.concesionariaautos.controller;

import org.example.concesionariaautos.dto.CarWithoutServicesDTO;
import org.example.concesionariaautos.service.IDealershipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("v1/api/vehicles")
public class DealershipController {
    @Autowired
    IDealershipService concesionariaService;

    @GetMapping
    ResponseEntity<List<CarWithoutServicesDTO>> findAllCars(){
        List<CarWithoutServicesDTO> cars = concesionariaService.findAllCars();
        if(cars == null){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(cars);
    }
}
