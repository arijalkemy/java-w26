package org.ejercicio.joyerialasperlas.controller;

import jakarta.validation.Valid;
import org.ejercicio.joyerialasperlas.dto.JoyaCreateDto;
import org.ejercicio.joyerialasperlas.dto.JoyaCreatedDto;
import org.ejercicio.joyerialasperlas.dto.JoyaResponseDto;
import org.ejercicio.joyerialasperlas.dto.JoyaUpdateDto;
import org.ejercicio.joyerialasperlas.service.IJoyaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("jewerly")
public class JoyaController {

    private IJoyaService joyaService;

    public JoyaController(IJoyaService joyaService) {
        this.joyaService = joyaService;
    }

    @GetMapping()
    public ResponseEntity<List<JoyaResponseDto>> obtenerJoyas() {
        return ResponseEntity.ok(joyaService.obtenerJoyas());
    }

    @PostMapping("new")
    public ResponseEntity<JoyaCreatedDto> guardarJoya(@RequestBody @Valid JoyaCreateDto joyaDto) {
        return new ResponseEntity<>(joyaService.guardarJoya(joyaDto),HttpStatus.CREATED);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> eliminarJoya(@PathVariable Long id) {
        joyaService.eliminarJoya(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("update/{id_modificar}")
    public ResponseEntity<JoyaResponseDto> actualizarJoya(@PathVariable Long id_modificar,
                                                          @RequestBody @Valid JoyaUpdateDto joyaDto) {
        return new ResponseEntity<>(joyaService.actualizarJoya(id_modificar,joyaDto) ,HttpStatus.OK);
    }

}
