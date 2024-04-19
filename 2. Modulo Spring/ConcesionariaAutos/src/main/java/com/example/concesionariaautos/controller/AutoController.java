package com.example.concesionariaautos.controller;

import com.example.concesionariaautos.dto.AutoDTO;
import com.example.concesionariaautos.model.Auto;
import com.example.concesionariaautos.service.ServiceAuto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/api/vehicles")
public class AutoController {

    @Autowired
    ServiceAuto serviceAuto;

    @PostMapping
    public ResponseEntity<Auto> addAuto(@RequestBody Auto auto) {
        serviceAuto.addAuto(auto);
        return new ResponseEntity<Auto>(auto, HttpStatus.OK);
    }

    @GetMapping()
    public List<AutoDTO> getAllAutos() {
        return serviceAuto.getAllAutos();
    }

    @GetMapping("/dates")
    public List<Auto> getCarsByDate(@RequestParam String since, @RequestParam String to) {
        return serviceAuto.getCarsByDate(since, to);
    }

    @GetMapping("/prices")
    public ResponseEntity<List<Auto>> getAutoInPriceRange(@RequestParam Integer since,@RequestParam Integer to) {
        return new ResponseEntity<>(serviceAuto.getAutoInRangePrice(since, to), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Auto> getSpecificCar(@PathVariable Integer id) {
        return new ResponseEntity<>(serviceAuto.getSpecificCar(id), HttpStatus.OK);
    }
}
