package com.meli.PracticaHQL.controller;

import com.meli.PracticaHQL.model.Siniestro;
import com.meli.PracticaHQL.model.Vehiculo;
import com.meli.PracticaHQL.repository.VehiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehiculos")
public class VehiculoController {

    @Autowired
    private VehiculoRepository vehiculoRepository;

    @GetMapping("/patentes")
    public List<String> getPatentes(){
        List<Vehiculo> vehiculos = (List<Vehiculo>) vehiculoRepository.findAll();
        return vehiculos.stream().map(Vehiculo::getPatente).toList();
    }

    @GetMapping("/patentesYMarcas")
    public List<String> getPatentesYMarcas(){
        List<Vehiculo> vehiculos = vehiculoRepository.findAllByOrderByAnioDeFabricacion();
        return vehiculos.stream().map(vehiculo -> vehiculo.getPatente() + " - " + vehiculo.getAnioDeFabricacion()).toList();
    }

    @GetMapping("/conCuatroRuedas")
    public List<String> getVehiculosConCuatroRuedas(){
        return vehiculoRepository.findAllByCantidadDeRuedasGreaterThanEqual(4)
                .stream().map(Vehiculo::getPatente).toList();
    }


    @PostMapping("/new")
    public Vehiculo createVehiculo(@RequestBody Vehiculo vehiculo){
        return vehiculoRepository.save(vehiculo);
    }

}
