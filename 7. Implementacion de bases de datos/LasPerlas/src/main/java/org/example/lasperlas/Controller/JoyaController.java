package org.example.lasperlas.Controller;

import org.example.lasperlas.DTO.CrearJoyaRequestDTO;
import org.example.lasperlas.Service.IJoyaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/jewerly")
public class JoyaController {

    @Autowired
    IJoyaService joyaService;

    @PostMapping("/new")
    public ResponseEntity<?> crearJoya(@RequestBody CrearJoyaRequestDTO crearJoyaRequestDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(joyaService.nuevaJoya(crearJoyaRequestDTO));
    }

    @GetMapping("")
    public ResponseEntity<?> obtenerJoyas() {
        return ResponseEntity.status(HttpStatus.OK).body(joyaService.traerJoyas());
    }

    @PatchMapping("/delete/{id}")
    public ResponseEntity<?> venderJoya(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(joyaService.vender(id));
    }

    @PutMapping("/update/{id_modificar}")
    public ResponseEntity<?> actualizarJoya(@PathVariable Long id_modificar,
                                            @RequestBody CrearJoyaRequestDTO joyaNuevaDTO) {
        return ResponseEntity.status(HttpStatus.OK).body(joyaService.actualizar(id_modificar, joyaNuevaDTO));
    }
}
