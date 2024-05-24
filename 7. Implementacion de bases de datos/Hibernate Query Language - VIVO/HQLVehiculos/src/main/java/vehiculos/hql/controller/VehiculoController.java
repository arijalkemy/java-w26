package vehiculos.hql.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vehiculos.hql.dto.SiniestroRequestDto;
import vehiculos.hql.dto.VehiculoRequestDto;
import vehiculos.hql.service.IVehiculoService;

@RestController
@RequestMapping("/vehiculo")
@RequiredArgsConstructor
public class VehiculoController {

    private final IVehiculoService vehiculoService;

    @PostMapping("/add")
    public ResponseEntity<?> newVehiculo(@RequestBody VehiculoRequestDto vehiculoRequestDto) {
        return new ResponseEntity<>(vehiculoService.saveVehiculo(vehiculoRequestDto),HttpStatus.CREATED);
    }

    @PostMapping("/addSiniestro")
    public ResponseEntity<?> newSiniestro(@RequestBody SiniestroRequestDto siniestroRequestDto) {
        return new ResponseEntity<>(vehiculoService.saveSiniestro(siniestroRequestDto),HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<?> allVehiculos() {
        return new ResponseEntity<>(vehiculoService.findAll(),HttpStatus.OK);
    }

    @GetMapping("/getPatentes")
    public ResponseEntity<?> getPatentes() {
        return new ResponseEntity<>(vehiculoService.getPatentes(),HttpStatus.OK);
    }

    @GetMapping("/getPatentesAndMarca")
    public ResponseEntity<?> getPatentesAndMarca() {
        return new ResponseEntity<>(vehiculoService.getPatentesAndMarca(),HttpStatus.OK);
    }

    @GetMapping("/getRuedas")
    public ResponseEntity<?> getRuedas() {
        return new ResponseEntity<>(vehiculoService.getRuedas(),HttpStatus.OK);
    }

    @GetMapping("/getPatentesModeloAndMarca")
    public ResponseEntity<?> getPatentesModeloAndMarca() {
        return new ResponseEntity<>(vehiculoService.getPatentesModeloAndMarca(),HttpStatus.OK);
    }

    @GetMapping("/getPerdidaTotal")
    public ResponseEntity<?> getPerdidaTotal() {
        return new ResponseEntity<>(vehiculoService.getPerdidaTotal(),HttpStatus.OK);
    }
}
