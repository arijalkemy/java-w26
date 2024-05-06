package com.viajescuidados.controllers;
import com.viajescuidados.dtos.ViajeDTO;
import com.viajescuidados.services.interfaces.IViajesService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ViajesController {
    @Autowired
    private IViajesService viajesService;

    @PostMapping("personas/{id}/viajes")
    public ResponseEntity<?> agregarViaje(@RequestBody @Valid ViajeDTO viajeDTO, @PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.viajesService.crearViaje(viajeDTO, id));
    }

    @PostMapping("viajes/{id}/comienzo")
    public ResponseEntity<?> comenzarViaje(@PathVariable Integer id) {
        return ResponseEntity.ok(this.viajesService.comenzarViaje(id));
    }
}