package com.hql.hql.controller;

import com.hql.hql.DTO.VehiculoPatenteMarcaDTO;
import com.hql.hql.model.Vehiculo;
import com.hql.hql.service.IVehiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/vehiculos")
public class VehiculoController {

    @Autowired
    IVehiculoService vehiculoService;

    @GetMapping("/patentes")
    public List<String> getPatentesVehiculos() {
        return vehiculoService.findLicensePlate();
    }
    @GetMapping("/patenteMarca")
    public List<VehiculoPatenteMarcaDTO> getPatentesAndMarcaVehiculos() {
        return vehiculoService.findPatenteMarcaInOrder();
    }

    @GetMapping("/patenteAnio")
    public List<String> getPatentesByAnio() {
        return vehiculoService.findLicenseByCurrentYear();
    }
}
