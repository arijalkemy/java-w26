package com.example._08_concesionaria.controller;

import com.example._08_concesionaria.dto.VehicleDTO;
import com.example._08_concesionaria.service.IVehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/v1/api/vehicles")
public class VehicleController {

    @Autowired
    IVehicleService iVehicleService;

    @PostMapping
    public ResponseEntity addVehicle(@RequestBody VehicleDTO vehicleDTO){
        boolean result = iVehicleService.addVehicle(vehicleDTO);
        if (result)
            return new ResponseEntity(HttpStatus.CREATED);

        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

    }


    @GetMapping
    public List<VehicleDTO> getAll(){
        List<VehicleDTO> vehicleDTOS = iVehicleService.getAll();

        if(vehicleDTOS.size() > 0)
            return  vehicleDTOS;

        return null;
    }

    @GetMapping("/dates")
    public ResponseEntity<List<VehicleDTO>> getBeetwenDates(@RequestParam Date dateSince, @RequestParam Date dateTo){
        List<VehicleDTO> vehicleDTOS = iVehicleService.getBetweenDates(dateSince, dateTo);

        if(vehicleDTOS.size()>0)
            return new ResponseEntity<>(vehicleDTOS, HttpStatus.OK);

        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @GetMapping("/prices")
    public ResponseEntity<List<VehicleDTO>> getBeetwenPrices(@RequestParam double priceSince, @RequestParam double priceTo){
        List<VehicleDTO> vehicleDTOS = iVehicleService.getBetweenPrices(priceSince, priceTo);

        if(vehicleDTOS.size()>0)
            return new ResponseEntity<>(vehicleDTOS, HttpStatus.OK);

        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @GetMapping("/{brand}")
    public ResponseEntity<VehicleDTO> getVehicle(@PathVariable String brand){
        VehicleDTO vehicleDTO = iVehicleService.getVehicle(brand);

        if(vehicleDTO != null)
            return new ResponseEntity<>(vehicleDTO, HttpStatus.OK);

        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }
}
