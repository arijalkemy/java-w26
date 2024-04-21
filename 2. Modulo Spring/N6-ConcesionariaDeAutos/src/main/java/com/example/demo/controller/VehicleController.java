package com.example.demo.controller;

import com.example.demo.dto.VehicleDto;
import com.example.demo.dto.VehicleResponseDto;
import com.example.demo.service.IVehicleService;
import com.example.demo.service.VehicleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/vehicles")
public class VehicleController {

    IVehicleService vehiclesService;

    @Autowired
    public VehicleController(VehicleServiceImpl vehiclesService) {
        this.vehiclesService = vehiclesService;
    }

    // Agrega un nuevo vehículo.
    @PostMapping
    public boolean addVehicle(@RequestBody VehicleDto vehicle){
         return vehiclesService.addVehicle(vehicle);
    }

    // Retorna un listado de todos los usados seleccionados. No incluye services.
    @GetMapping
    public List<VehicleResponseDto> getVehicles(){
        return vehiclesService.getVehicles();
    }

    // Retorna el listado de los vehículos según fecha de fabricación.
    // /dates?since=’’to=’’
    @GetMapping("/dates")
    public List<VehicleDto> getVehiclesBetweenDates(@RequestParam  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date since,
                                         @RequestParam  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date to){
        return vehiclesService.getVehiclesBetweenDates(since, to);
    }

    // Muestra el listado de los vehículos según los precios dados.
    // /prices?since=’’to=’’
    @GetMapping("/prices")
    public List<VehicleDto> getVehiclesBetweenPrices(@RequestParam Double since, @RequestParam Double to){
        return vehiclesService.getVehiclesBetweenPrices(since, to);
    }

    // Muestra toda la información relacionada con el vehículo.
    @GetMapping("{id}")
    public VehicleDto getVehicle(@PathVariable Long id){
        return vehiclesService.getVehicle(id);
    }

}
