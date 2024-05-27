package meli.bootcamp.aseguradora.controllers;

import meli.bootcamp.aseguradora.services.interfaces.IVehicleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/vehiculos")
public class VehiculoController {

    final IVehicleService vehicleService;

    public VehiculoController(IVehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getVehiculoById(Long id) {
        return new ResponseEntity<>(
                vehicleService.getVehiculoById(id),
                HttpStatus.OK
        );
    }

    @GetMapping
    public ResponseEntity<?> findAll(){
        return new ResponseEntity<>(
                vehicleService.findAll(),
                HttpStatus.OK
        );
    }

    @GetMapping("/patentes")
    public ResponseEntity<?> findAllPatentes(){
        return new ResponseEntity<>(
                vehicleService.findAllPatentes(),
                HttpStatus.OK
        );
    }

    @GetMapping("/patentes/marca")
    public ResponseEntity<?> findAllPatentesAndMarcaOrderByAnioFabricacion(){
        return new ResponseEntity<>(
                vehicleService.findAllPatentesAndMarcaOrderByAnioFabricacion(),
                HttpStatus.OK
        );
    }

    @GetMapping("/patentes/cantidad-ruedas/anio-fabricacion-actual")
    public ResponseEntity<?> findAllPatentesByCantidadRuedasMayorACuatroAndAnioFabricacionActual(){
        return new ResponseEntity<>(
                vehicleService.findAllPatentesByCantidadRuedasMayorACuatroAndAnioFabricacionActual(),
                HttpStatus.OK
        );
    }

    @GetMapping("/matricula/marca/modelo/siniestro-perdida-mayor-a-10000")
    public ResponseEntity<?> findAllMatriculaMarcaModeloBySiniestroPerdidaMayorA10000(){
        return new ResponseEntity<>(
                vehicleService.findAllMatriculaMarcaModeloBySiniestroPerdidaMayorA10000(),
                HttpStatus.OK
        );
    }

    @GetMapping("/matricula/marca/modelo/siniestro-perdida-mayor-a-10000/perdida-total")
    public ResponseEntity<?> findAllMatriculaMarcaModeloBySiniestroPerdidaMayorA10000AndPerdidaTotal(){
        return new ResponseEntity<>(
                vehicleService.findAllMatriculaMarcaModeloBySiniestroPerdidaMayorA10000AndPerdidaTotal(),
                HttpStatus.OK
        );
    }



}
